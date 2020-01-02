package Move;

import Arena.Arena;
import Champion.Champion;
import Game.consoleGame;
import GameStore.TemporalStoreFilter;
import Player.Player;

import java.awt.*;
import java.util.Scanner;

public class SellMove extends Move {

    public Champion printLisForSellMove(Player p , Arena arena){
        Champion move = new Champion();

        if(p.getBenchChampions().size()==0){

            System.err.println("Your Bench is empty please buy some champions to sell them later... ");
            move = null;

        }
        else {
            for(int i=0 ; i<p.getBenchChampions().size();i++){
                System.out.print(consoleGame.ConsoleColors.YELLOW+(i+1)+"||\t"+ consoleGame.ConsoleColors.RESET);
                System.out.println(p.getBenchChampions().get(i));
                System.out.println(consoleGame.ConsoleColors.YELLOW+"==========================================================================================================================================================================="+ consoleGame.ConsoleColors.RESET);
            }
            System.out.println("Please choose a champion to sell: ");
            Scanner scanner = new Scanner(System.in);
            int sellChampion = scanner.nextInt();
            if(sellChampion > p.getBenchChampions().size()){
                System.err.println("Please enter a right number: ");
                printLisForSellMove(p,arena);
            }
            else{
                System.out.println("Your chosen champion is : "+p.getBenchChampions().get(sellChampion-1));
                move =p.getBenchChampions().get(sellChampion-1);
            }




        }
        return move;


    }
    public Champion printLisForSellMoveForAutoPlayer(Player p , Arena arena){
        Champion move = new Champion();

        if(p.getBenchChampions().size()==0){

            System.err.println("Your Bench is empty please buy some champions to sell them later... ");
            move = null;
        }
        else {
            for(int i=0 ; i<p.getBenchChampions().size();i++){
                System.out.print(consoleGame.ConsoleColors.YELLOW+(i+1)+"||\t"+ consoleGame.ConsoleColors.RESET);
                System.out.println(p.getBenchChampions().get(i));
                System.out.println(consoleGame.ConsoleColors.YELLOW+"==========================================================================================================================================================================="+ consoleGame.ConsoleColors.RESET);
            }
            System.out.println("Please choose a champion to sell: ");
            int sellChampion = 1;
            System.out.println("Your chosen champion is : "+p.getBenchChampions().get(sellChampion-1));
            move =p.getBenchChampions().get(sellChampion-1);
        }


        return move;

    }

    public void PerformMove(Player p , Arena arena,Champion sellChampion){


        if(p.getBenchChampions().size()==0){

            System.err.println("Your Bench is empty please buy some champions to sell them later... ");

        }
        else {
        Champion c =new Champion();
        c = sellChampion;
        p.getBenchChampions().remove(c);
        p.setCoins(p.getCoins()+c.GoldCost);
        System.out.println("Your coins now are: "+p.getCoins());
        }
    }

    public void PerformMoveForAutoPlayer(Player p , Arena arena,Champion c1){


        if(p.getBenchChampions().size()==0){

            System.err.println("Your Bench is empty please buy some champions to sell them later... ");

        }
        else {
        System.out.println("Please choose a champion to sell: ");
        int sellChampion = 1;
        System.out.println("Your chosen champion is : "+p.getBenchChampions().get(sellChampion-1));
        Champion c =new Champion();
        c = c1;
        p.getBenchChampions().remove(c);
        p.setCoins(p.getCoins()+c.GoldCost);
        System.out.println("Your coins now are: "+p.getCoins());

        }

    }



}
