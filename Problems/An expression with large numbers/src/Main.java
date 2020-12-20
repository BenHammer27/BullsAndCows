import java.util.Scanner;
import java.math.BigInteger;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger a = scanner.nextBigInteger();
        BigInteger b = scanner.nextBigInteger();
        BigInteger c = scanner.nextBigInteger();
        BigInteger d = scanner.nextBigInteger();

        BigInteger e = a.negate();
        BigInteger f = e.multiply(b);
        BigInteger g = f.add(c);
        BigInteger h = g.subtract(d);

        System.out.println(h);
    }
}