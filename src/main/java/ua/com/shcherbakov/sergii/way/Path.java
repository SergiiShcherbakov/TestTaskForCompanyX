package ua.com.shcherbakov.sergii.way;

import ua.com.shcherbakov.sergii.utisl.Viewer;
import java.util.Arrays;

/**
 * Created by Sergii Shcherbakov on 23.05.2017.
 *
 * The class setup and stories path and find minimal cost by Dijkstra algorithm
 * The algorithm create weight graph with minimal cost to all element.
 */
public class Path {
    public static final int HAVE_NOT_WEIGHT = -1;

    int idStart;
    int idFinish;
    int [] minCost; // index is element`s id.  weight graph with minimal cost to all element.
    CityHolder cities;

    public Path(Viewer console, CityHolder cities) {
        this.cities = cities;
        while (true) {
            console.testWriteLine("Please enter name findMinimalCostInAllTestsAndPrintIt and finish to the way ");
            try {
                String namesInLine = console.readLine();
                String[] names = namesInLine.split(" ");
                idStart = cities.getIdByName(names[0]);
                idFinish = cities.getIdByName(names[1]);
                return;
            } catch (Exception e) {
                console.testWriteLine("incorrect input, try again");
            }
        }
    }

    public int getMinimalCost() {
        dijkstraWeightCreate();
        return minCost[idFinish];
    }

    private void dijkstraWeightCreate() {
        minCost = new int[cities.getSize()+1]; // for id 0. system - don`t use city with id 0.
        Arrays.fill(minCost, HAVE_NOT_WEIGHT);
        minCost[idStart] = 0;
        setWeightNeighbours(idStart, cities);
    }

    private void setWeightNeighbours(int idCity, CityHolder cities) {
        int[] neighbours = cities.getNeighboursById(idCity);
        int[] neighboursCosts = cities.getNeighboursCostsById(idCity);
        for (int i = 0; i < neighbours.length; i++) {
            int neighbourId = neighbours[i];
            int newCost = minCost[idCity] + neighboursCosts[i];
            if( isNeedToSetNewWeight( neighbourId, newCost )){
                setWeight(neighbourId, newCost);
                setWeightNeighbours(neighbourId, cities);
            }
        }
    }

    private void setWeight(int idCity, int newWeight){
        minCost[idCity] = newWeight;
    }

    private boolean isNeedToSetNewWeight(int idCity, int newWeight){
        int currentWeight = minCost[idCity];
        if(currentWeight == HAVE_NOT_WEIGHT){
            return true;
        } else if(currentWeight > newWeight && currentWeight > 0) {
            return true;
        }
        return false;
    }
}
