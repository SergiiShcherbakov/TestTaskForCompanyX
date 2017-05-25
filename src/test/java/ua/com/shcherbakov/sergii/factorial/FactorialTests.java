package ua.com.shcherbakov.sergii.factorial;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Sergii Shcherbakov on 22.05.2017.
 */
public class FactorialTests {
    Factorial f;

    @Before
    public void set(){
        f = new Factorial();
    }

    @Test(expected = IllegalArgumentException.class)
    public void factorialFromLessNull(){
        // given
        BigInteger input = BigInteger.valueOf(-1);
        // when
        BigInteger answer = f.getFactorial(input);
        // then
    }

    @Test
    public void factorialFrom0(){
        // given
        BigInteger input = BigInteger.valueOf(0);
        BigInteger expected = BigInteger.valueOf(1);
        // when
        BigInteger answer = f.getFactorial(input);
        // then
        assertEquals(expected, answer);
    }

    @Test
    public void factorialFrom2(){
        // given
        BigInteger input = BigInteger.valueOf(2);
        BigInteger expected = BigInteger.valueOf(2);
        // when
        BigInteger answer = f.getFactorial(input);
        // then
        assertEquals(expected, answer);
    }

    @Test
    public void factorialFrom10(){
        // given
        BigInteger input = BigInteger.valueOf(10);
        BigInteger expected = BigInteger.valueOf(3_628_800L);
        // when
        BigInteger answer = f.getFactorial(input);
        // then
        assertEquals(expected, answer);
    }

    @Test
    public void factorialFrom100(){
        // given
        BigInteger input = BigInteger.valueOf(100);
        BigInteger expected = new BigInteger("9332621544394415268169923885626670049071596826438" +
                "1621468592963895217599993229915608941463976156518286253697920827223758251185210916" +
                "864000000000000000000000000");
        // when
        BigInteger answer = f.getFactorial(input);
        // then
        assertEquals(expected, answer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sumFactorialDigitsFromLess0(){
        // given
        int input = -1;
        // when
        f.getSumDigits(input);
        // then
    }

    @Test
    public void sumFactorialDigitsFrom0(){
        // given
        int input = 0;
        int expected = 1;
        // when
        int answer = f.getSumDigits(input);
        // then
        assertEquals(expected, answer);
    }

    @Test
    public void sumFactorialDigitsFrom1(){
        // given
        int input = 1;
        int expected = 1;
        // when
        int answer = f.getSumDigits(input);
        // then
        assertEquals(expected, answer);
    }

    @Test
    public void sumFactorialDigitsFrom2(){
        // given
        int input = 2;
        int expected = 2;
        // when
        int answer = f.getSumDigits(input);
        // then
        assertEquals(expected, answer);
    }

    @Test
    public void sumFactorialDigitsFrom10(){
        // given
        int input = 10;
        int expected = 27;
        // when
        int answer = f.getSumDigits(input);
        // then
        assertEquals(expected, answer);
    }

    @Test
    public void sumFactorialDigitsFrom100(){
        // given
        int input = 100;
        int expected = 648;
        // when
        int answer = f.getSumDigits(input);
        // then
        assertEquals(expected, answer);
    }
}
