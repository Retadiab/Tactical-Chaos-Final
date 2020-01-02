package Arena;

import Arena.SquaresState;
import Champion.Champion;
import Items.Item;
import Move.PlaceMove;
import Player.Player;

import java.util.ArrayList;

public class Squares {
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private int x;
    private int y;
    SquaresState state;
    public Item item ;

    public SquaresType getType() {
        return type;
    }

    public void setType(SquaresType type) {
        this.type = type;
    }

    SquaresType type;


    public Squares(int i , int j ) {
        x = i ;
        y = j ;

    }

    ArrayList<Champion> championsIn = new ArrayList<Champion>();

    public ArrayList<Player> getPlayersIn() {
        return playersIn;
    }

    public void setPlayersIn( Player p ) {
         this.playersIn.add(p);

    }

    ArrayList<Player> playersIn = new ArrayList<Player>();


    public ArrayList<Champion> getChampionsIn() {
        return championsIn;
    }

    public void setChampionsIn(Champion c) {
        this.championsIn.add(c);
    }







    public SquaresState getState() {
        return state;
    }

    public void setState(SquaresState state) {
        this.state = state;
    }

}
