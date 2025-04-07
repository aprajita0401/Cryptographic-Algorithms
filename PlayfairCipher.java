import java.util.*;

public class PlayfairCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the plaintext: ");
        String plaintext = sc.nextLine().replaceAll("\\s+", "").toUpperCase().replace("J", "I");

        System.out.println("Enter the keyword: ");
        String keyword = sc.nextLine();

        char[][] matrix = generateMatrix(keyword);
        String text = digraph(plaintext);
        String cipheredText = Encrypt(text, matrix);

        System.out.println("Encrypted text: " + cipheredText);
    }

    // Converts plaintext into digraphs (e.g., BALLOON -> BALXLOON)
    public static String digraph(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i += 2) {
            char a = str.charAt(i);
            char b = (i + 1 < str.length()) ? str.charAt(i + 1) : 'X';

            sb.append(a);
            if (a == b) {
                sb.append('X');
                i--; // Stay on same char with 'X'
            } else {
                sb.append(b);
            }
        }

        return sb.toString();
    }

    // Generates 5x5 Playfair matrix using the secret keyword
    public static char[][] generateMatrix(String keyword) {
        keyword = keyword.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        LinkedHashSet<Character> set = new LinkedHashSet<>();

        for (char ch : keyword.toCharArray()) {
            set.add(ch); //adding the keyword to the HashSet to make sure only unique letters are present in the matrix
        }

        for (char c = 'A'; c <= 'Z'; c++) {
            if (c != 'J')
                set.add(c); //adding rest of the unique letters
        }

        char[][] mat = new char[5][5];
        Iterator<Character> it = set.iterator();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (it.hasNext()) {
                    mat[i][j] = it.next(); //adding all the unique letters to the matrix
                }
            }
        }

        return mat;
    }

    // Finds position of a character in the matrix
    private static int[] findPosition(char[][] matrix, char ch) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j] == ch) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // Encrypts digraph using Playfair rules
    public static String Encrypt(String text, char[][] matrix) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i += 2) {
            char a = text.charAt(i), b = text.charAt(i + 1);
            int[] posA = findPosition(matrix, a);
            int[] posB = findPosition(matrix, b);

            if (posA[0] == posB[0]) { // Same row
                result.append(matrix[posA[0]][(posA[1] + 1) % 5]);
                result.append(matrix[posB[0]][(posB[1] + 1) % 5]);
            }

            else if (posA[1] == posB[1]) { // Same column
                result.append(matrix[(posA[0] + 1) % 5][posA[1]]);
                result.append(matrix[(posB[0] + 1) % 5][posB[1]]);
            }

            else { // Rectangle swap
                result.append(matrix[posA[0]][posB[1]]);
                result.append(matrix[posB[0]][posA[1]]);
            }
        }
        return result.toString();
    }
}
