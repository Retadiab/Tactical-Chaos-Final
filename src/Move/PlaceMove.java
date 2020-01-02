package Move;

import Arena.*;

import Champion.Champion;
import Player.Player;

import java.util.ArrayList;

public class PlaceMove extends Move {


boolean donePlaced = false;

    public boolean placeMove(int x , int y , Champion p, Arena a , ArrayList<Player> players , Player playerForSquare){


                System.out.println(x + " " + y);
                a.getSquare(x,y).setChampionsIn(p);
                a.getSquare(x,y).setPlayersIn(playerForSquare);


//                System.out.println("champions on araena");
//                System.out.println(a.getSquare(x,y).getPlayersIn());
                p.x = x ;
                p.y = y ;
                a.getSquare(x,y).setState(SquaresState.Occupied);
//        if (a.getSquare(x,y).item != null && p.items.size()<=3)
//        {
//            p.items.add(a.getSquare(x,y).item);
//            a.getSquare(x,y).item.equip(p);  //lazm nt.thkr nshel al item lma n3ml 2no mat 2ao nba3 al champion
//            System.out.println(p+"have take this item "+a.getSquare(x,y).item.toString());
//            a.getSquare(x,y).item = null ;
//
//        }
//        if (p.items.size()>3 && a.getSquare(x,y).item!=null)
//            System.out.println("you can't equip this item because you have 3 items");
        //remember to delete the champoin from the old square cuz i used your place move in walk move :P
                //remember to delete the champoin from the old square cuz i used your placemove in walkmove :P
        return donePlaced =true;

    }
    public boolean placeMoveForWalkMove(int x , int y , Champion p, Arena a , ArrayList<Player> players , Player playerForSquare){

        System.out.println(x + " " + y);
        a.getSquare(x,y).setChampionsIn(p);
        a.getSquare(x,y).setPlayersIn(playerForSquare);


//                System.out.println("champions on araena");
//                System.out.println(a.getSquare(x,y).getPlayersIn());
        p.x = x ;
        p.y = y ;
        a.getSquare(x,y).setState(SquaresState.Occupied);
        //remember to delete the champoin from the old square cuz i used your placemove in walkmove :P
        return donePlaced =true;

    }
}
