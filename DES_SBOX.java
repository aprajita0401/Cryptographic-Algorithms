import java.util.Scanner;

public class DES_SBOX {
    // Example S-Box (Using S1 from DES)
    static int[][] S_BOX = {
            {14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7},
            {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8},
            {4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},
            {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}
    };

    // Function for S-Box substitution
    public static void sBoxSubstitution(String sixBitInput) {
        //converting into decimal to find the row and column
        int row = Integer.parseInt("" + sixBitInput.charAt(0) + sixBitInput.charAt(5), 2); // First & last bit
        int col = Integer.parseInt(sixBitInput.substring(1, 5), 2); // Middle 4 bits

        int sBoxValue = S_BOX[row][col]; // Lookup in S-Box
        String fourBitOutput = String.format("%4s", Integer.toBinaryString(sBoxValue)).replace(' ', '0');

        // Print details
        System.out.println("S-Box Value: " + sBoxValue + " (Binary: " + fourBitOutput + ")");
        System.out.println("Final Output: " + fourBitOutput);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a 6-bit binary input: ");
        String input = scanner.next();

        // Validate input
        if (!input.matches("[01]{6}")) {
            System.out.println("Invalid input! Please enter exactly 6 bits.");
        } else {
            sBoxSubstitution(input);
        }

    }
}