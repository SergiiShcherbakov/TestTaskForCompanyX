package ua.com.shcherbakov.sergii.way;

import ua.com.shcherbakov.sergii.utisl.Viewer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergii Shcherbakov on 23.05.2017.
 *
 * The class setup and stores all cities in the test.
 * it setup cities from Viewer.
 * it stories cities in ArrayList where index of element is them id in the system.
 */
public class CityHolder {
    private List<City> cities; // index is id city

    public CityHolder(Viewer console) {
        setCitiesFromConsole( console);
    }

    private void setCitiesFromConsole(Viewer console) {
        console.testWriteLine("please set the number of cities");
        int numberOfCities = console.readIntAndCheck();
        cities = new ArrayList<>(numberOfCities+1);
        cities.add(null); // for id 0. system - don`t use city with id 0.
        for (int i = 1; i <= numberOfCities; i++) {
            cities.add(new City(i, console));
        }
    }
    
    public int getIdByName(String name){
        for (City city : cities) {
            if( city != null && city.isTheCityName(name)) {
                return city.getId();
            }
        }
        throw new IllegalArgumentException("The city holder haven`t element with name " + name + "\"");
    }


    public int getSize() {
        return cities.size() - 1 ; // for id 0. system - don`t use city with id 0.
    }

    public int[] getNeighboursById(int idCity) {
        return cities.get(idCity).getNeighboursId();
    }

    public int[] getNeighboursCostsById(int idCity) {
        return cities.get(idCity).getNeighboursCost();
    }
}
