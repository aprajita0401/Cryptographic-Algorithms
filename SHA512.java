import java.util.*;
public class SHA512 {
    public static String toBinary(int n){
        return Integer.toBinaryString(n);
    }
    public static int calcBitPadding(int n){
        int multiplier = 1;
        while(multiplier*1024<(n+128))
        {
            multiplier++;
        }
        return (multiplier*1024)-(n+128);
    }
    public static String countMaj(int A, int B, int C){
        //Majority(A,B,C) = (A AND B) XOR (B AND C) XOR (C AND A)
        int a1 = A & B;
        int b1 = B & C;
        int c1 = C & A;
        int maj1 = (a1 & ~b1) | (~a1 & b1);
        int maj = (c1 & ~maj1) | (~c1 & maj1);
        return toBinary(maj);
    }
    public static String countCon(int E, int F, int G){
        //conditional(E,F,G) = (E AND F) XOR (~E AND G)
        int a1 = E & F;
        int b1 = ~E & G;
        int con = (a1 & ~b1) | (~a1 & b1);
        return toBinary(con);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the message in binary format: ");
        String message = sc.nextLine();

        System.out.println("Length of original message (bits): " + message.length());
        int padding = calcBitPadding(message.length()) + message.length();

        System.out.println("Size of padding (bits): " + calcBitPadding(message.length()));

        System.out.println("Length of message after padding (bits): " + padding);

        System.out.println("The total size of the blocks after including the padding bits is: " + (padding + message.length() + 128));

        System.out.println("The total size of the blocks after including the padding bits is: " + ((padding + message.length() + 128)/1024));

        //the message is followed by 1 and zeros
        StringBuilder paddingBitsString = new StringBuilder("1");
        for (int i = 1; i < calcBitPadding(message.length()); i++) {
            paddingBitsString.append("0");
        }
        System.out.println("The padding bits along with the number of bits (excluding the size of the message{128}): " + message + paddingBitsString);

        System.out.println("Enter A, B, C, E, F, G in decimal format: ");
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int E = sc.nextInt();
        int F = sc.nextInt();
        int G = sc.nextInt();

        //Majority Function and Conditional Function
        String maj = countMaj(A, B, C);
        String con = countCon(E, F, G);
        System.out.println("Majority Function of A, B and C: " + maj);
        System.out.println("Conditional Function of E, F and G: " + con);
    }
}
