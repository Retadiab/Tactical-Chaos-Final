package Rounds;

import Arena.Arena;
import Champion.*;

import java.util.ArrayList;

public class Plan {


    PlanState planeState;
    ArrayList<Integer> Choices = new ArrayList<Integer>();
    Arena gameArena = new Arena();

    public Arena getGameArena() {
        return gameArena;
    }

    public void setGameArena(Arena gameArena) {
        this.gameArena = gameArena;
    }

     public void setPlaneState(PlanState planeState) {
        this.planeState = planeState;
    }


    public ArrayList<Integer> getChoices() {
        return Choices;
    }

    public void setChoices(Integer choice) {
        Choices.add(choice);
    }


    ArrayList<Champion> champions = new ArrayList<Champion>();

    public ArrayList<Champion> getChampions() {
        return champions;
    }

    public void setChampions(Champion champion) {
        this.champions.add(champion);
    }



//    ArrayList
    public Plan(){
        planeState = PlanState.Empty;
    }







}
