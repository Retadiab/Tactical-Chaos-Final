package GameStore;

import Champion.Champion;

import java.util.ArrayList;

public class Bench {
    ArrayList<Champion> benchChampions = new ArrayList<Champion>();


    public ArrayList<Champion> getBenchChampions() {
        return benchChampions;
    }

    public void setBenchChampions(ArrayList<Champion> benchChampions) {
        this.benchChampions = benchChampions;
    }

}
