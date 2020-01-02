package Arena;


import Champion.Champion;
import Game.consoleGame;
import Items.Item;
import Move.PlaceMove;
import Player.Player;
import sun.awt.Symbol;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import static Items.ItemsFactory.getItem;

public  class Arena {
    public static Squares[][] getSquares() {
        return squares;
    }

    public static void setSquares(Squares[][] squares) {
        Arena.squares = squares;
    }

    static Squares[][] squares;
    public void setArenaSize(int arenaSize) {
        this.arenaSize = arenaSize;
    }

    int arenaSize= 100;

    SquaresState State;
    SquaresType Type;
    SquaresType Type1;
    ArrayList<SquaresType> Types= new ArrayList<SquaresType>();
    int index;
    public Arena() {
       squares = new Squares[arenaSize][arenaSize];
        for (SquaresType type : SquaresType.values()) {
            Types.add(type);
        }

       for (int i = 0; i < arenaSize; i++) {
            for (int j = 0; j < arenaSize; j++) {
                this.squares[i][j] = new Squares(i,j);
                this.squares[i][j].setState(State.Free);
                this.squares[i][j].item = RandomItem() ;
                this.squares[i][j].item.x = i;
                this.squares[i][j].item.y = j ;
                index = new Random().nextInt(Types.size());
               Type = Types.get(index);
                this.squares[i][j].setType(Type);
//                System.out.println("type of the square   "+this.squares[i][j].getType());
            }
        }
    }
    public void printAllChampionsInTheArena() {


        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 55; j++) {


                if(squares[i][j].getState() == State.Free){
                    switch (squares[i][j].getType()){
                        case grass:
                            {
                            System.out.print(consoleGame.ConsoleColors.GREEN_BOLD+ "| [###] |"+consoleGame.ConsoleColors.RESET);
                                break;

                        }

                        case water:{
                            System.out.print(consoleGame.ConsoleColors.BLUE_BOLD+ "| [###] |"+consoleGame.ConsoleColors.RESET);
                            break;

                        }

                        case terrain:{
                            System.out.print(consoleGame.ConsoleColors.CYAN_BOLD+ "| [###] |"+consoleGame.ConsoleColors.RESET);
                            break;

                        }
                        case standard:{
                            System.out.print(consoleGame.ConsoleColors.PURPLE_BOLD+ "| [###] |"+consoleGame.ConsoleColors.RESET);
                            break;


                        }
                        default:{

                            System.out.print("| [###] |");
                            break;

                        }




                    }







                }
                else if(squares[i][j].getState() == State.Occupied) {


                    for(Champion c : squares[i][j].getChampionsIn()){






//                        System.out.println();
//                        System.out.println("squares champ  "+squares[i][j].championsIn);
//                        System.out.println("squares type  "+squares[i][j].getType());
//                        System.out.println("squares state  " +squares[i][j].getState());
//                        System.out.println("squares coords  " +squares[i][j].getX()+squares[i][j].getY());



                        switch (squares[i][j].getType()){



                            case grass:
                            {
                                System.out.print(consoleGame.ConsoleColors.GREEN_UNDERLINED+"| [" + consoleGame.ConsoleColors.RED_UNDERLINED+c.toInitials() + "P" + c.getPlayerId() +consoleGame.ConsoleColors.GREEN_UNDERLINED+"] |"+consoleGame.ConsoleColors.RESET);
                                break;

                            }

                            case water:{
                                System.out.print(consoleGame.ConsoleColors.BLUE_UNDERLINED+"| [" + consoleGame.ConsoleColors.RED_UNDERLINED+c.toInitials() + "P" + c.getPlayerId() +consoleGame.ConsoleColors.BLUE_UNDERLINED+"] |"+consoleGame.ConsoleColors.RESET);
                                break;

                            }

                            case terrain:{
                                System.out.print(consoleGame.ConsoleColors.CYAN_UNDERLINED+"| [" + consoleGame.ConsoleColors.RED_UNDERLINED+c.toInitials() + "P" + c.getPlayerId() +consoleGame.ConsoleColors.CYAN_UNDERLINED+"] |"+consoleGame.ConsoleColors.RESET);
                                break;

                            }
                            case standard:{
                                System.out.print(consoleGame.ConsoleColors.PURPLE_UNDERLINED+"| [" + consoleGame.ConsoleColors.RED_UNDERLINED+c.toInitials() + "P" + c.getPlayerId() +consoleGame.ConsoleColors.PURPLE_UNDERLINED+"] |"+consoleGame.ConsoleColors.RESET);
                                break;


                            }
                            default:{

                                System.err.print("| [" + c.toInitials() + "P" + c.getPlayerId() +"] |");
                                break;

                            }




                        }







                    }
                    continue;

                }
                else {
                    System.err.print("squares[i][j]");


                }

            }
            System.out.println("");
            System.out.println("");

        }

    }

    public void printArena() {


        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 55; j++) {

                switch (squares[i][j].getType()) {
                    case grass: {
                        System.out.print(consoleGame.ConsoleColors.GREEN_BOLD + "| [###] |" + consoleGame.ConsoleColors.RESET);
                        break;
                    }

                    case water: {
                        System.out.print(consoleGame.ConsoleColors.BLUE_BOLD + "| [###] |" + consoleGame.ConsoleColors.RESET);
                        break;
                    }

                    case terrain: {
                        System.out.print(consoleGame.ConsoleColors.CYAN_BOLD + "| [###] |" + consoleGame.ConsoleColors.RESET);
                        break;
                    }
                    case standard: {
                        System.out.print(consoleGame.ConsoleColors.PURPLE_BOLD + "| [###] |" + consoleGame.ConsoleColors.RESET);
                        break;

                    }
                    default: {

                        System.out.print("| [###] |");
                        break;
                    }


                }


            }
            System.out.println("");

        }

    }
    public void printArena(Player p ) {


//        for (int i = 0; i < 14; i++) {
//            for (int j = 0; j < 55; j++) {
//
//
//                if(squares[i][j].getState() == State.Free){
//                    System.out.print("| [###] |");
//                }
//                else if(squares[i][j].getState() == State.Occupied) {
//                    boolean championPrint = false;
//                    for(Champion c : squares[i][j].getChampionsIn()){
//                        if(c.playerId == p.getPlayerIndex()) {
//
//                            championPrint = true;
//                            System.err.print(" | [" + c.toInitials() + "P" + c.getPlayerId() + "] |");
//
//
//                        }
//
//                    }
//                    if (!championPrint){
//                        System.out.print("| [###] |");
//
//                    }
//
//
//                }
////                else {
////                    System.err.print("");
//////
////
////                }
//            }
//            System.out.println("");
//
//        }


        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 55; j++) {


                if(squares[i][j].getState() == State.Free){
                    switch (squares[i][j].getType()){
                        case grass:
                        {
                            System.out.print(consoleGame.ConsoleColors.GREEN_BOLD+ "| [###] |"+consoleGame.ConsoleColors.RESET);
                            break;

                        }

                        case water:{
                            System.out.print(consoleGame.ConsoleColors.BLUE_BOLD+ "| [###] |"+consoleGame.ConsoleColors.RESET);
                            break;

                        }

                        case terrain:{
                            System.out.print(consoleGame.ConsoleColors.CYAN_BOLD+ "| [###] |"+consoleGame.ConsoleColors.RESET);
                            break;

                        }
                        case standard:{
                            System.out.print(consoleGame.ConsoleColors.PURPLE_BOLD+ "| [###] |"+consoleGame.ConsoleColors.RESET);
                            break;


                        }
                        default:{

                            System.out.print("| [###] |");
                            break;

                        }




                    }







                }
                else if(squares[i][j].getState() == State.Occupied) {





                        boolean championPrint = false;
                        for(Champion c : squares[i][j].getChampionsIn()){
                            if(c.playerId == p.getPlayerIndex()) {

                                championPrint = true;




//                        System.out.println();
//                        System.out.println("squares champ  "+squares[i][j].championsIn);
//                        System.out.println("squares type  "+squares[i][j].getType());
//                        System.out.println("squares state  " +squares[i][j].getState());
//                        System.out.println("squares coords  " +squares[i][j].getX()+squares[i][j].getY());



                        switch (squares[i][j].getType()){



                            case grass:
                            {
                                System.out.print(consoleGame.ConsoleColors.GREEN_UNDERLINED+"| [" + consoleGame.ConsoleColors.RED_UNDERLINED+c.toInitials() + "P" + c.getPlayerId() +consoleGame.ConsoleColors.GREEN_UNDERLINED+"] |"+consoleGame.ConsoleColors.RESET);
                                break;

                            }

                            case water:{
                                System.out.print(consoleGame.ConsoleColors.BLUE_UNDERLINED+"| [" + consoleGame.ConsoleColors.RED_UNDERLINED+c.toInitials() + "P" + c.getPlayerId() +consoleGame.ConsoleColors.BLUE_UNDERLINED+"] |"+consoleGame.ConsoleColors.RESET);
                                break;

                            }

                            case terrain:{
                                System.out.print(consoleGame.ConsoleColors.CYAN_UNDERLINED+"| [" + consoleGame.ConsoleColors.RED_UNDERLINED+c.toInitials() + "P" + c.getPlayerId() +consoleGame.ConsoleColors.CYAN_UNDERLINED+"] |"+consoleGame.ConsoleColors.RESET);
                                break;

                            }
                            case standard:{
                                System.out.print(consoleGame.ConsoleColors.PURPLE_UNDERLINED+"| [" + consoleGame.ConsoleColors.RED_UNDERLINED+c.toInitials() + "P" + c.getPlayerId() +consoleGame.ConsoleColors.PURPLE_UNDERLINED+"] |"+consoleGame.ConsoleColors.RESET);
                                break;


                            }
                            default:{

                                System.err.print("| [" + c.toInitials() + "P" + c.getPlayerId() +"] |");
                                break;

                            }




                        }







                    }

                            if (!championPrint){
                                System.out.print("| [###] |");

                            }

                }}


                }
            System.out.println("");
            System.out.println("");

            }

        }




    public void printChampionsWithVisionRange(Player p1){

        ArrayList<Champion> visionChampions = new ArrayList<Champion>();

        for(Champion c : p1.getArenaChampions()){
            int stX = c.x - (int)(c.VisionRange/5);
            if(stX<0) stX = 0;

            int  stY = c.y - (int)(c.VisionRange/5);

            if(stY<0) stY = 0;

            for (int i = stX; i < (int)(stX+((c.VisionRange/5)*2)); i++) {


                for (int j = stY; j<(int)((stY+(c.VisionRange/5)*2)); j++) {


                    if(squares[i][j].getState() == SquaresState.Free){
                        continue;

                    }
                    else if(squares[i][j].getState() == SquaresState.Occupied) {
                        for(int w =0 ; w<squares[i][j].getChampionsIn().size();w++ ){


                            visionChampions.add(squares[i][j].getChampionsIn().get(w));

                        }
                        }
                    }


                }

            }
        System.out.println("champions in vision range");

        for(int k =0 ; k<visionChampions.size(); k++){

            System.out.println(visionChampions.get(k));

        }



        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 55; j++) {


                boolean print =false;

                    for(Champion c : visionChampions){
                        if(c.x == i && c.y == j)
                        {

                            System.err.print(" | [" + c.toInitials() + "P" + c.getPlayerId() + "] |");
                            print =true;

                        }
                        else {

                            continue;
                        }

                    }

                    if(!print){
                        System.out.print("| [###] |");

                    }


                }


            System.out.println("");

        }
}




    public Squares getSquare(int i, int j) {
        return this.squares[i][j];
    }

    public void setSquares(int i, int j) {
        this.squares[i][j].setX(i);

    }

    public int getArenaSize() {
        return this.arenaSize;
    }

ArrayList<Champion> allChampionsOnArena = new ArrayList<Champion>();
    public ArrayList<Champion> getAllChampionsOnArena(){
        for(int i = 0; i < 14; i++)
        {
            for(int j = 0; j < 55; j++) {
                for(int k= 0 ; k<squares[i][j].getChampionsIn().size() ; k++)
                    allChampionsOnArena.add(squares[i][j].getChampionsIn().get(k));


            }




    }
    return allChampionsOnArena;
    }



    static Random r = new Random() ;
    static public Item RandomItem(){
        int  x= getRandom(7 , 1);
        return getItem(x);
    }


    public static int   getRandom(int h , int l)
    {
        return r.nextInt((h-l)+1)+l ;}




    public static void main(String[] args) {
       // Arena a =new Arena();

        for (int i = 0 ; i <6 ; i++){
            Item item =  RandomItem() ;
            System.out.print(i+ "  ");
            System.out.println(item);}

        System.out.println("\n \n \n \n");


//        Arena arena = new Arena();
//        for (int i = 0 ; i <14 ; i++)
//            for (int j = 0 ; j <55 ; j++){
//                System.out.println("this is square"+i+j+"item");
//                System.out.println(arena.getSquare(i,j).item.toString());}
    }

}
