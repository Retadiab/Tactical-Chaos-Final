package Player;

import Champion.Champion;
import GameStore.Bench;

import java.util.ArrayList;

public abstract class Player {
    String name;
    Bench playerBench = new Bench();
    ArrayList<Champion> currentChampions = new ArrayList<Champion>();
    ArrayList<Champion> arenaChampions = new ArrayList<Champion>();
    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    int coins =2;
    public int getPlayerIndex() {
        return PlayerIndex;
    }

    public void setPlayerIndex(int playerIndex) {
        PlayerIndex = playerIndex;
    }

    int PlayerIndex;
    public ArrayList<Champion> getBenchChampions() {
        return playerBench.getBenchChampions();
    }



    public ArrayList<Champion> setBenchChampions(ArrayList<Champion> benchChampions) {

        ArrayList<Champion> benchChampions1 = new ArrayList<Champion>();
        playerBench.setBenchChampions(benchChampions);
         return benchChampions1;
    }



    public ArrayList<Champion> getCurrentChampions() {
        return currentChampions;
    }

    public void setCurrentChampions(ArrayList<Champion> currentChampions) {
        this.currentChampions = currentChampions;
    }

    public void PropagateMove(){};

    public abstract void setName(String playerName);

    public ArrayList<Champion> getArenaChampions() {
        return arenaChampions;
    }

    public void setArenaChampions(Champion arenaChampion) {
        this.arenaChampions.add(arenaChampion);
    }
}
