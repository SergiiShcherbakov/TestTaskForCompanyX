package ua.com.shcherbakov.sergii.way;

import ua.com.shcherbakov.sergii.utils.Viewer;

import java.util.Arrays;

/**
 * Created by Sergii Shcherbakov on 22.05.2017.
 * The class stories information about one City
 *
 */
public class City {
    final int id;
    String name;
    int[] neighboursId;
    int[] neighboursCost;


    public City(int id, Viewer console) {
        this.id = id;
        setCityFromConsole(console);
    }

    public boolean isTheCityName(String name) {
        return this.name.equals(name);
    }

    public int getId() {
        return id;
    }

    public int[] getNeighboursId() {
        return Arrays.copyOf(neighboursId, neighboursId.length);
    }

    public int[] getNeighboursCost() {
        return Arrays.copyOf(neighboursCost, neighboursCost.length);
    }

    private void setCityFromConsole( Viewer console ) {
        setNameFromConsole(console);
        setNeighboursFromConsole(console);
    }

    private void setNeighboursFromConsole(Viewer console) {
        console.testWriteLine("Please enter how much neighbours has the the city:");
        int countNeighbours = console.readIntAndCheck();
        neighboursId = new int[countNeighbours];
        neighboursCost = new int[countNeighbours];
        for (int i = 0; i < countNeighbours ; i++) {
            setNeighbourFromConsole(i, console);
        }
    }

    private void setNeighbourFromConsole(int id, Viewer console) {
        while (true){
            try{
                console.testWriteLine("please enter city id and transportation cost in format: \"id\" \"cost\" ");
                String costAndName = console.readLine();
                String[] costAndNameArr = costAndName.split(" ");
                int cityId = Integer.parseInt(costAndNameArr[0]);
                int cost = Integer.parseInt(costAndNameArr[1]);
                neighboursId[ id ] =  cityId ;
                neighboursCost[ id ] = cost ;
                return;
            } catch (Exception e){
                console.testWriteLine("something wrong. We have a problem with input, please try again");
                console.testWriteLine("please enter city id and transportation cost in format: \"id\" \"cost\" ");
            }
        }
    }

    private void setNameFromConsole(Viewer console) {
        console.testWriteLine("please enter city name");
        this.name = console.readLine();
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", neighbours=" + neighboursPrint() +
                '}';
    }

    private String neighboursPrint() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < neighboursId.length; i++) {
            result.append(neighboursId[i]).append(" ").append(neighboursCost[i]).append(" ,");
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }

}