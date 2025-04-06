import java.util.*;
public class MD5 {
    public static String toBinary(int n){
        return Integer.toBinaryString(n);
    }
    public static int AND(int a, int b){
        return a & b;
    }
    public static int XOR(int f1, int f2){
        return (f1 & ~f2) | (~f1 & f2);
    }
    public static int calcBitPadding(int n){
        int multiplier = 1;
        while(multiplier * 512 < (n + 64))
        {
            multiplier++;
        }
        return (multiplier * 512) - (n + 64);
    }

    public static String G(int B, int C, int D){
        //G(B, C, D) = (B AND D) OR (C AND ~D)
        int func = AND(B, D) | AND(C, ~D);
        return toBinary(func);
    }

    public static String F(int B, int C, int D){
        //F(B, C, D) = (B AND C) OR (~B AND D)
        int func = AND(B, C) | AND(~B, D);
        return toBinary(func);
    }

    public static String H(int B, int C, int D){
        //H(B, C, D) = B XOR C XOR D
        int func = XOR(B, C);
        int func1 = XOR(func, D);
        return toBinary(func1);
    }

    public static String I(int B, int C, int D){
        //I(B, C, D) = C XOR (B OR ~D)
        int func = (B | ~D);
        int func1 = (func & ~C) | (~func & C);
        return toBinary(func1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the message in binary format: ");
        String message = sc.nextLine();

        System.out.println("Length of original message (bits): " + message.length());
        int padding = calcBitPadding(message.length()) + message.length();

        System.out.println("Size of padding (bits): " + calcBitPadding(message.length()));

        System.out.println("Length of message after padding (bits): " + padding);

        System.out.println("The total size of the blocks after including the padding bits is: " + (padding + message.length() + 64));

        System.out.println("Total number of blocks: "+ ((padding + message.length() + 64)/512));

        //the message is followed by 1 and zeros
        StringBuilder paddingBitsString = new StringBuilder("1");
        for (int i = 1; i < calcBitPadding(message.length()); i++) {
            paddingBitsString.append("0");
        }
        System.out.println("The padding bits along with the number of bits (excluding the size of the message{128}): " + message + paddingBitsString);

        System.out.println("Enter B, C, Din decimal format: ");
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();

        //Auxilliary Functions
        String aux1 = F(B, C, D);
        String aux2 = G(B, C, D);
        String aux3 = H(B, C, D);
        String aux4 = I(B, C, D);
        System.out.println("The Auxiliary Functions: ");
        System.out.println("F(B, C, D) = " + aux1);
        System.out.println("G(B, C, D) = " + aux2);
        System.out.println("H(B, C, D) = " + aux3);
        System.out.println("I(B, C, D) = " + aux4);

    }
}
