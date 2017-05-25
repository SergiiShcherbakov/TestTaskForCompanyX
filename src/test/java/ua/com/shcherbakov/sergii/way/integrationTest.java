package ua.com.shcherbakov.sergii.way;

import org.junit.Test;
import org.mockito.Mockito;
import ua.com.shcherbakov.sergii.utils.ConsoleViewer;
import ua.com.shcherbakov.sergii.utils.Viewer;

/**
 * Created by Sergii Shcherbakov on 24.05.2017.
 *
 */
public class integrationTest {
    @Test
    public void integrationTestWith5CitiesAnd1Way() {
        // given
        Main main = new Main();
        Viewer viewer = Mockito.mock(ConsoleViewer.class);
        Mockito.when( viewer.readLine() ).thenReturn(
                "1" , //test
                "5", //count cities
                 // cities
                "A", "2", "2 1", "3 3",
                "B", "3", "1 1", "3 1", "4 5",
                "C", "4", "1 3", "2 1", "4 3", "5 1",
                "D", "3", "2 5", "3 3", "5 1",
                "E", "2", "3 1", "4 1",
                //way to find
                "1", "A D",
                 //empty line
                "" );
        Mockito.when( viewer.readIntAndCheck() ).thenCallRealMethod();
        // when
        main.main( viewer );
        // then
        Mockito.verify(viewer).writeLine("4");
    }

 @Test
    public void integrationTestWith5CitiesAnd1WayAndTwoTests() {
        // given
        Main main = new Main();
        Viewer viewer = Mockito.mock(ConsoleViewer.class);
        Mockito.when( viewer.readLine() ).thenReturn(
                "2" , //test
                "5", //count cities
                 // cities
                "A", "2", "2 1", "3 3",
                "B", "3", "1 1", "3 1", "4 5",
                "C", "4", "1 3", "2 1", "4 3", "5 1",
                "D", "3", "2 5", "3 3", "5 1",
                "E", "2", "3 1", "4 1",
                //way to find
                "1", "A D",
                 //empty line
                "\n" ,
                "5", //count cities
                // cities
                "A", "2", "2 1", "3 3",
                "B", "3", "1 1", "3 1", "4 5",
                "C", "4", "1 3", "2 1", "4 3", "5 1",
                "D", "3", "2 5", "3 3", "5 1",
                "E", "2", "3 1", "4 1",
                //way to find
                "1", "A D",
                //empty line
                "");
        Mockito.when( viewer.readIntAndCheck() ).thenCallRealMethod();
        // when
        main.main( viewer );
        // then
        Mockito.verify(viewer, Mockito.times(2)).writeLine("4");
    }

    @Test
    public void integrationTestWith4CitiesAnd2Ways() {
        // given
        Main main = new Main();
        Viewer viewer = Mockito.mock(ConsoleViewer.class);
        Mockito.when( viewer.readLine() ).thenReturn(
                "1",
                "4",
                "gdansk",
                "2",
                "2 1",
                "3 3",
                "bydgoszcz",
                "3",
                "1 1",
                "3 1",
                "4 4",
                "torun",
                "3",
                "1 3",
                "2 1",
                "4 1",
                "warszawa",
                "2",
                "2 4",
                "3 1",
                "2",
                "gdansk warszawa",
                "bydgoszcz warszawa",
                "\n"  );
        Mockito.when( viewer.readIntAndCheck() ).thenCallRealMethod();
        // when
        main.main( viewer );
        //then
        Mockito.verify(viewer).writeLine("3");
        Mockito.verify(viewer).writeLine("2");
    }
}