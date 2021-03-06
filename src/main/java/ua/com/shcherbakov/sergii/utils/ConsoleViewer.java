package ua.com.shcherbakov.sergii.utils;

import java.util.Scanner;

/**
 * Created by Sergii Shcherbakov on 20.05.2017.
 *
 * The class reads realizes interface Viewer in console;
 */
public class ConsoleViewer implements Viewer {

    /**
     * the method need fot testing,
     * you can use it like logger and remove inside logic after finish
     *  string line that inputted to console.
     */
    @Override
    public void testWriteLine(String line) {
        //do nothing
        //System.out.print( "CV:" + line + System.lineSeparator());
    }


    @Override
    public void writeLine(String line) {
        System.out.print(  line + System.lineSeparator());
    }

    /**
     * the method readLine string line from console.
     * @return string line that inputted to console.
     */
    @Override
    public String readLine(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    /**
     * the method readLine long value from console.
     * If inputted other string the method asks input long value.
     * @return long value that inputted to console.
     */
    @Override
    public long readLongAndCheck(){
       String input = readLine();
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e){
            // not long value
            writeLine(String.format( "input \"%s\" but expected long" , input ));
            writeLine("please try again" );
            return readLongAndCheck();
        }
    }

    /**
     * the method read int value from console.
     * If inputted other string the method asks input int value.
     * @return int value that inputted to console.
     */
    @Override
    public int readIntAndCheck(){
       String input = readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            // not long value
            System.out.println(String.format( "input \"%s\" but expected integer" , input ) );
            System.out.println("please try again" );
            return readIntAndCheck();
        }
    }
}

