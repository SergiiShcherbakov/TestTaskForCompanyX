package ua.com.shcherbakov.sergii.utisl;

/**
 * Created by Sergii Shcherbakov on 23.05.2017.
 *
 * The interface need for use pattern strategy and change input and output
 * in the program
 */

public interface Viewer {

    void testWriteLine(String line );

    void WriteLine(String line );

    String readLine();

    long readLongAndCheck();

    int readIntAndCheck();
}
