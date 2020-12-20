import java.math.BigInteger;

class DoubleFactorial {
    public static BigInteger calcDoubleFactorial(int n) {
        BigInteger result = BigInteger.ONE;

        for (int i = n; i > 0; ){
            BigInteger next = BigInteger.valueOf(i);
            result = result.multiply(next);
            i -= 2;
        }

        return result;
    }
}