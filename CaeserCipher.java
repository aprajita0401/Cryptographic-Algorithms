import java.util.*;

public class CaeserCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to encrypt: ");
        String str = sc.nextLine().toLowerCase(); // Convert input to lowercase

        System.out.println("The ciphered text is: " + caesarCipher(str));
    }
    //Caeser cipher encrypts only alphabets from A-Z or a-z
    public static StringBuilder caesarCipher(String input) {
        StringBuilder cipheredText = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            //add the whitespaces to the cipheredText (whitespaces do not get ciphered in Caeser cipher)
            if (ch == ' ') {
                cipheredText.append(' ');
            }
            else {
                int index = ch - 'a'; //to find ASCII value of ch
                int shiftedIndex = (index + 3) % 26; //caesar cipher formula
                char encryptedChar = (char) ('a' + shiftedIndex); //converting ASCII value to char
                cipheredText.append(encryptedChar);
            }
        }
        return cipheredText;
    }
}
