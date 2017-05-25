package ua.com.shcherbakov.sergii.way;

import ua.com.shcherbakov.sergii.utils.ConsoleViewer;
import ua.com.shcherbakov.sergii.utils.Viewer;

/**
 * Created by Sergii Shcherbakov on 23.05.2017.
 *
 * The class findMinimalCostInAllTestsAndPrintIt program.
 * The program is test number 2
 * Tee test takes data from console and find the minimal cost betveen several points.
 *
 * input format:
 *      s [the number of tests <= 10]
 *      n [the number of cities <= 10000]
 *      NAME [city name]
 *      p [the number of neighbours of city NAME]
 *      nr cost [nr - index of a city connected to NAME (the index of the first city is 1)]
 *          [cost - the transportation cost]
 *      r [the number of paths to find <= 100]
 *      NAME1 NAME2 [NAME1 - source, NAME2 - destination]
 *      [empty line separating the tests]
 *
 * output format:
 *      cost [the minimum transportation cost from city NAME1 to city NAME2 (one per line)]
 *
 */
public class Main {
    /**
    *  The method need for integration tests.
    *  It findMinimalCostInAllTestsAndPrintIt the program.
    *  It takes Viewer. The viewer controls input and output in the program.
    */
    public void main(Viewer console) {
        TestHolder tests = new TestHolder(console);
        tests.findMinimalCostInAllTestsAndPrintIt(console);
    }


    public static void main(String[] args) {
        Main main = new Main();
        main.main(new ConsoleViewer());
    }
}
