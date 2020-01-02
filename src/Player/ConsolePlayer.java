package Player;

import Champion.Champion;
import GameStore.Bench;
import Rounds.Plan;

import java.util.ArrayList;

public  class ConsolePlayer extends Player {
    String name;

    public Plan getPlayerPlan() {
        return playerPlan;
    }

    public void setPlayerPlan(Plan playerPlan) {
        this.playerPlan = playerPlan;
    }

    public Plan playerPlan = new Plan();

    Bench playerBench = new Bench();
    ArrayList<Champion> currentChampions = new ArrayList<Champion>();

    public ArrayList<Champion> getArenaChampions() {
        return arenaChampions;
    }

    public void setArenaChampions(Champion arenaChampion) {
        this.arenaChampions.add(arenaChampion);
    }

    ArrayList<Champion> arenaChampions = new ArrayList<Champion>();

    public ArrayList<Champion> getBenchChampions() {
        return playerBench.getBenchChampions();
    }



    public ArrayList<Champion> setBenchChampions(ArrayList<Champion> benchChampions) {

        ArrayList<Champion> benchChampions1 = new ArrayList<Champion>();
        playerBench.setBenchChampions(benchChampions);
        return benchChampions1;
    }


    int PlayerIndex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public int getIndex() {
        return PlayerIndex;
    }

    public void setIndex(int PlayerIndex) {
        this.PlayerIndex = PlayerIndex;;
    }




    public void setCurrentChampions(ArrayList<Champion> currentChampions) {
        this.currentChampions = currentChampions;
    }

    public ArrayList<Champion> getCurrentChampions() {
        return currentChampions;
    }

    int money= 0 ;



}
