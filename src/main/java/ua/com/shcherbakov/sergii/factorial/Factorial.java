package ua.com.shcherbakov.sergii.factorial;

import java.math.BigInteger;

/**
 * Created by Sergii Shcherbakov on 22.05.2017.
 * class Factorial realizes methods getFactorial and getSumDigits
 */
public class Factorial {
    /**
     * The method defines sum of digits factorial of n.
     * @param n - input number of element in factorial sequence.
     * @return int with sum of digits factorial of n.
     * @throws IllegalArgumentException if input value less than 0.
     */
    public int getSumDigits(int n){
        int result = 0;
        char digits;
        String factorial = getFactorial( BigInteger.valueOf(n)).toString();
        for (int i = 0; i < factorial.length(); i++) {
            digits = factorial.charAt(i);
            result += Integer.parseInt(digits + "");
        }
        return result;
    }

    /**
     * The method defines factorial of n.
     * @param n input number of element in factorial sequence.
     * @return BigInteger with factorial fo n.
     * @throws IllegalArgumentException if input value less than 0.
     */
    public BigInteger getFactorial(BigInteger n ){
        if ( n.compareTo( BigInteger.valueOf(0)) == -1 ) {
            throw new IllegalArgumentException(" input value is \"" +
                    n + "\" but expected value more ore equal 0 ");
        } else if (n.intValue() == 0 || n.intValue() == 1 ) {
            return BigInteger.valueOf(1);
        } else {
            return n.multiply(getFactorial(n.subtract(BigInteger.valueOf(1))));
        }
    }
}
