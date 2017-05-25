package ua.com.shcherbakov.sergii.way;

import ua.com.shcherbakov.sergii.utils.Viewer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sergii Shcherbakov on 23.05.2017.
 *
 * The class contains all test in the program
 * It use interface Viewer for input and output data from source
 *
 */
public class TestHolder {

    public static final int MAX_NUMBER_OF_TESTS = 10;
    public static final int MIN_NUMBER_OF_TESTS = 1;

    List<TestWay> tests;

    TestHolder(Viewer consoleViewer){
        setAllTestsFromConsole(consoleViewer);
    }

    private void setAllTestsFromConsole(Viewer console) {
        int numberOfTests = setNumberOfTestFromConsole(console);
        tests = new LinkedList<>();
        for (int i = 0; i < numberOfTests ; i++) {
            tests.add( new TestWay(console));
            console.readLine(); // read empty line after test
        }
    }

    private int setNumberOfTestFromConsole(Viewer console) {
        while (true) {
            console.testWriteLine("Please, set the number of tests more or equals than " + MIN_NUMBER_OF_TESTS +
                    " and les or equals " + MAX_NUMBER_OF_TESTS );
            int numberOfTests = console.readIntAndCheck();
            if (numberOfTests >= MIN_NUMBER_OF_TESTS && numberOfTests <= MAX_NUMBER_OF_TESTS) {
                return numberOfTests;
            } else {
                console.testWriteLine("Set wrong number, try again");
            }
        }
    }

    public void findMinimalCostInAllTestsAndPrintIt(Viewer console) {
        for (TestWay test : tests) {
            test.findMinimalCostWayAndPrintIt(console);
        }
    }
}
