import java.util.*;
import java.math.BigInteger;
public class RSA{
    public static BigInteger calcD(BigInteger e, BigInteger phin){
        BigInteger r1 = phin;
        BigInteger r2 = e;
        BigInteger t0 = BigInteger.ZERO;
        BigInteger t1 = BigInteger.ONE;

        while (!r2.equals(BigInteger.ZERO)) {
            //perform GCD
            BigInteger q = r1.divide(r2); //to find the quotient
            BigInteger r = r1.mod(r2); //to find remainder
            BigInteger t = t0.subtract(q.multiply(t1)); //to find dividend t = t0 - (q*t1)

            r1 = r2;
            r2 = r;
            t0 = t1;
            t1 = t;
        }

        if (t0.compareTo(BigInteger.ZERO) < 0) {
            t0 = t0.add(phin);
        }

        return t0;
    }
    public static BigInteger encrypt(BigInteger m, BigInteger e, BigInteger n){
        return m.modPow(e,n); // encrypted message = ((message)^public key) mod n;
    }
    public static BigInteger decrypt(BigInteger c, BigInteger d, BigInteger n){
        return c.modPow(d,n); // decrypted message = ((encrypted message)^private key) mod n;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two prime numbers:");
        BigInteger p = sc.nextBigInteger();
        BigInteger q = sc.nextBigInteger();
        BigInteger n = p.multiply(q);
        BigInteger phin = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        System.out.println("Enter the value of e. e should satisfy the following rules: 1 < e < phi(n) and GCD(e, phi(n)) = 1");
        BigInteger e = sc.nextBigInteger();
        System.out.println("Enter the value of the message in decimal format:");
        BigInteger m = sc.nextBigInteger();
        BigInteger d = calcD(e, phin);
        BigInteger c = encrypt(m, e, n);
        BigInteger mess = decrypt(c, d, n);
        System.out.println("Public Key: {"+e+", "+n+"}");
        System.out.println("Private Key: {"+d+", "+n+"}");
        System.out.println("The encrypted message is: " + c);
        System.out.println("The decrypted message is: " + mess);
    }
}