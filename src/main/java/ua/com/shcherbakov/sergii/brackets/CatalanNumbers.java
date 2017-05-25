package ua.com.shcherbakov.sergii.brackets;

import java.math.BigInteger;

/**
 * Created by Sergii Shcherbakov on 21.05.2017.
 *
 * class CatalanNumbers realizes method getNumberByN.
 * Method getNumberByN returns Catalans number for n.
 */
public class CatalanNumbers {
    /**
     * The method returns Catalans number for n
     * @param n n-th element in the Catalan sequence
     * @return the Catalans number for n-th element
     * throws IllegalArgumentException if input value less than 0.
     */
    public BigInteger getNumberByN(long n) {
        if (n < 0) {
            throw new IllegalArgumentException(" input value is \"" +
            n + "\" but expected value more ore equal 0 ");
        } else if (n == 0) {
            return  BigInteger.valueOf(1L);
        } else if(n < 34 ) {
            return BigInteger.valueOf(
                    ((4L * n) - 2L) * (getNumberByN(n - 1L).longValue()) / (n + 1L)) ;
       } else {
            return  BigInteger.valueOf((4L * n) - 2L).
                    multiply(getNumberByN(n - 1L)).
                    divide(BigInteger.valueOf(n + 1L));
       }
    }
}
