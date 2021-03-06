package ua.com.shcherbakov.sergii.brackets;

import ua.com.shcherbakov.sergii.utils.Viewer;
import ua.com.shcherbakov.sergii.utils.ConsoleViewer;

import java.math.BigInteger;

/**
 * Created by Sergii Shcherbakov on 21.05.2017.
 * Te class starts first decision for the first test.
 * The test finds count of right brackets expressions from n numbers brackets.
 * The class uses:
 *      Viewer to readLine data from console.
 *      And class CorrectBracketsExpressions to find count right brackets expressions.
 */
public class Main {
    public static void main(String[] args) {
        Viewer viewer = new ConsoleViewer();
        CorrectBracketsExpressions expressions = new CorrectBracketsExpressions();

        System.out.println("Please input number of pair brackets ");
        int countOfBrackets = viewer.readIntAndCheck();
        BigInteger answer = expressions.getCount( countOfBrackets );

        System.out.println(
                String.format("From %d pair of brackets can build %s variants right expressions",
                        countOfBrackets, answer));
    }
}
