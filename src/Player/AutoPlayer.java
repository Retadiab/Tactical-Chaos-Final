package Player;

import Champion.Champion;

import java.util.ArrayList;

public class AutoPlayer extends Player {


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

    public int getPlayerIndex() {
        return PlayerIndex;
    }

    public void setPlayerIndex(int playerIndex) {
        PlayerIndex = playerIndex;
    }

    int PlayerIndex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

}
