package ua.com.shcherbakov.sergii.brackets;

import java.math.BigInteger;

/**
 * Created by Sergii Shcherbakov on 21.05.2017.
 *
 * class CorrectBracketsExpressions realizes method correctBracketsExpressions.
 * Method correctBracketsExpressions defines count of right bracket expressions that
 * can be built from input count of pair brackets.
 */
public class CorrectBracketsExpressions {
    /**
     * The method defines count of right brackets expressions that
     * can be built from input count of pair brackets.
     * It use class CatalanNumbers to find number n-th element from numerical sequence Catalan numbers.
     * The number shows count unique variants right brackets expressions.
     * @param PairBrackets  count of pair brackets.
     * @return BigInteger value with count of correct bracket expressions.
     * @throws IllegalArgumentException if input value less than 0.
     */
    BigInteger getCount(int PairBrackets) throws IllegalArgumentException{
        if(PairBrackets == 0) return BigInteger.valueOf(0);
        return new CatalanNumbers().getNumberByN(PairBrackets);
    }
}
