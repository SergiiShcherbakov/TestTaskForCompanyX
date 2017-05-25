package ua.com.shcherbakov.sergii.way;

import ua.com.shcherbakov.sergii.utils.Viewer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sergii Shcherbakov on 23.05.2017.
 *
 * The class realizes test that find minimal const in path
 * It setup cities and setup paths from viewer
 */
public class TestWay {

    public static final int MAX_COUNT_PATHS = 100;
    public static final int MIN_COUNT_PATHS = 1;

    private CityHolder cities;
    private List<Path> paths;

    public TestWay(Viewer console) {
        setTestWayFromConsole(console);
    }

    private void setTestWayFromConsole(Viewer console){
        cities = new CityHolder(console);
        setAllPathsFromConsole(console);
    }

    public void findMinimalCostWayAndPrintIt(Viewer console) {
        for (Path path : paths) {
            console.writeLine( path.getMinimalCost()+"");
        }
    }

    private void setAllPathsFromConsole(Viewer console) {
        int countPaths = setNumberOfPathsFromConsole(console);
        paths = new LinkedList<>();
        for (int i = 0; i < countPaths; i++) {
            paths.add( new Path(console, cities));
        }
    }

    private int setNumberOfPathsFromConsole(Viewer console){
        while (true) {
            console.testWriteLine("Please, set the number of paths what need to find. " +
                    "It can be more or equals than " + MIN_COUNT_PATHS +
                    " and les or equals than " + MAX_COUNT_PATHS );
            int countPaths = console.readIntAndCheck();
            if(countPaths >= MIN_COUNT_PATHS && countPaths <= MAX_COUNT_PATHS){
                return countPaths;
            } else {
                console.testWriteLine("Set wrong number, try again");
            }
        }
    }

}
