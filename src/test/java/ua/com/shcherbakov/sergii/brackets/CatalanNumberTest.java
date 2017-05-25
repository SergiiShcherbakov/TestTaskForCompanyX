package ua.com.shcherbakov.sergii.brackets;

import org.junit.Before;
import org.junit.Test;
import java.math.BigInteger;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Sergii Shcherbakov on 21.05.2017.
 */
public class CatalanNumberTest {
    CatalanNumbers catalanNumbers ;

    @Before
    public void set(){
        catalanNumbers = new CatalanNumbers();
    }

    @Test(expected = IllegalArgumentException.class)
    public void valueLessThan0(){
        // given
        long input = -1;
        // when
        catalanNumbers.getNumberByN(input);
    }

    @Test
    public void valueEquals0(){
        // given
        long input = 0;
        BigInteger expected = BigInteger.valueOf(1L);
        // when
        BigInteger answer = catalanNumbers.getNumberByN(input);
        // then
        assertEquals(expected, answer);
    }

    @Test
    public void valueEquals1(){
        // given
        long input = 1;
        BigInteger expected = BigInteger.valueOf(1L);
        // when
        BigInteger answer = catalanNumbers.getNumberByN(input);
        // then
        assertEquals(expected, answer);
    }

    @Test
    public void valueEquals2(){
        // given
        long input = 2;
        BigInteger expected = BigInteger.valueOf(2L);
        // when
        BigInteger answer = catalanNumbers.getNumberByN(input);
        // then
        assertEquals(expected, answer);
    }

    @Test
    public void valueEquals3(){
        // given
        long input = 3;
        BigInteger expected = BigInteger.valueOf(5L);
        // when
        BigInteger answer = catalanNumbers.getNumberByN(input);
        // then
        assertEquals(expected, answer);
    }

    @Test
    public void valueEquals4(){
        // given
        long input = 4;
        BigInteger expected = BigInteger.valueOf(14L);
        // when
        BigInteger answer = catalanNumbers.getNumberByN(input);
        // then
        assertEquals(expected, answer);
    }

    @Test
    public void valueEquals5(){
        // given
        long input = 5;
        BigInteger expected = BigInteger.valueOf(42L);
        // when
        BigInteger answer = catalanNumbers.getNumberByN(input);
        // then
        assertEquals(expected, answer);
    }


    @Test
    public void valueEquals100(){
        // given
        long input = 100;
        BigInteger expected = new BigInteger("896519947090131496687170070074100632420837521538745909320");
        // when
        BigInteger answer = catalanNumbers.getNumberByN(input);
        // then
        assertEquals(expected, answer);
    }
}
