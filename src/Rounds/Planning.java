//package UnassignedClasses;
//
//public class Planning extends Round{
//    private int newField(){return 0;};
//    public void GetTemporalList(){};
//
//}
package Rounds;



import Arena.Arena;
import Exceptions.IllegalSquare;
import Game.consoleGame;
import GameStore.TemporalStoreFilter;
import Champion.Champion;
import Move.*;
import Player.Player;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static Damage.Level.Level2;

public class Planning extends Round{
     private boolean err =false;
    static Scanner x =new Scanner(System.in);
    static Scanner x1 =new Scanner(System.in);
    static Scanner x2 =new Scanner(System.in);
    static Scanner indexOfChosenChampionScanner =new Scanner(System.in);
    static Scanner xCoorScanner = new Scanner(System.in);
    static Scanner yCoorScanner = new Scanner(System.in);
    ArrayList<String> plan = new ArrayList<String>();
    static Scanner championToMove =new Scanner(System.in);
    static Scanner ChampionToAttackWith =new Scanner(System.in);
    static Scanner ChampionToBeAttacked =new Scanner(System.in);

    static ArrayList<Champion> championsForPlan = new ArrayList<Champion>();

    static Random r = new Random() ;




    public static int   getRandom(int l , int h)
    {
        return r.nextInt((h-l)+1)+l ;}

    private int newField(){return 0;};
    public void GetTemporalList(){};

    public int printPlanningListPhase1(boolean phase2){
        if(this.err){
            System.out.println(consoleGame.ConsoleColors.CYAN_BOLD+"1-"+ consoleGame.ConsoleColors.RESET +" Buy champions.");
        }

        else {
            System.out.println(consoleGame.ConsoleColors.CYAN_BOLD+"1-"+ consoleGame.ConsoleColors.RESET +"Buy champions.");
        }

        System.out.println(consoleGame.ConsoleColors.CYAN_BOLD+"2-"+ consoleGame.ConsoleColors.RESET +"Place your champions.");


        if(phase2)
        System.out.println(consoleGame.ConsoleColors.CYAN_BOLD+"3-"+ consoleGame.ConsoleColors.RESET +"Sell champions.");



        System.out.println("Your choice is: ");
        int userChoice= x.nextInt();
        return userChoice;
    }

    public int printPlanningListPhase2MovesList(){

//        System.err.println("Please choose your plan: ");
        System.out.println("1- None");
        System.out.println("2- Walk move.");
        System.out.println("3- Attack a champion.");
        System.out.println("4- Use ability for specific champion.");
        System.out.println("5- Swap.");

        System.out.println("Your choice is: ");


        int userChoice= x.nextInt();
        return userChoice;



    }



    public boolean levelup(Champion c, Player p)
    {
        String champname = c.championName;

        int benchCounter =0; int arenaCounter=0;
        for(Champion cc: p.getBenchChampions())
        {
            if (cc.championName == champname)
            {
                benchCounter++;
            }
        }
        Champion tempchamp =  new Champion();
        for(Champion cc: p.getArenaChampions())
        {
            if (cc.championName == champname)
            {
                arenaCounter++;

                tempchamp.x = cc.x;
                tempchamp.y = cc.y;

            }
        }
        if(benchCounter==1 && arenaCounter ==1)
        {
            c.x = tempchamp.x;
            c.y = tempchamp.y;
            Level2(c);
            for(Champion cc: p.getBenchChampions())
            {
                if (cc.championName == champname)
                {
                    p.getBenchChampions().remove(cc);
                    break;
                }
            }
            for(Champion cc: p.getArenaChampions())
            {
                if (cc.championName == champname)
                {
                    p.getArenaChampions().remove(cc);
                    break;
                }
            }
            p.getCurrentChampions().add(c);
            p.getArenaChampions().add(c);
            return true;
        }
        else if(benchCounter ==2)
        {

            Level2(c);
            ArrayList<Champion> toremove= new ArrayList<>();
            for(Champion cc: p.getBenchChampions())
            {
                if (cc.championName == champname)
                {
                    toremove.add(cc);
                }
            }
            p.getBenchChampions().removeAll(toremove);
            p.getCurrentChampions().add(c);
            p.getBenchChampions().add(c);
            return true;
        }
        else if (arenaCounter==2)
        {
            c.x = tempchamp.x;
            c.y = tempchamp.y;
            Level2(c);
            ArrayList<Champion> toremove= new ArrayList<>();
            for(Champion cc: p.getArenaChampions())
            {
                if (cc.championName == champname)
                {
                    toremove.add(cc);
                }
            }
            p.getArenaChampions().removeAll(toremove);
            p.getCurrentChampions().add(c);
            p.getArenaChampions().add(c);
            return true;
        }
        return false;
    }
public boolean getChampionChoiceFromPhase1(int userChoice, Player p, Arena arena, ArrayList<Player> indexOfPlayerToPrintItWithArena,int wayOfPlanning, boolean phase2){

boolean isRound = false;


//System.out.println("palesfred iddd" + indexOfPlayerToPrintItWithArena) ;
        switch (userChoice) {




            case (1):
            {

                System.out.println("1");

                ArrayList<Champion> addedChampions = new ArrayList<Champion>();
                BuyMove move1 = new BuyMove();

//                System.out.println(addedChampions);
                if(p.getBenchChampions().size()<=9) {
                    if(p.getBenchChampions().size()==9){
                        System.err.println("Your Bench is full, Please place some Champions to free some spaces in the Bench!!! ");
                        this.err=true;
                        break;
                    }
                    else {
                        System.out.println("champions array size" + p.getBenchChampions().size());


                        addedChampions = move1.doBuying(5);
                        ArrayList<Champion> leveledup = new ArrayList<>();
                        for(Champion c1 : addedChampions){

                            c1.setPlayerId(p.getPlayerIndex());

//                            System.out.println("champions with player id : "+c1.getPlayerId());
                            if(levelup(c1,p))
                            {
                                leveledup.add(c1);
                            }


                        }
                        addedChampions.removeAll(leveledup);

                        p.getCurrentChampions().addAll(addedChampions);
                        p.getBenchChampions().addAll(addedChampions);
//                        System.out.println("champions with player id : ");

//                    System.out.println();
//                    System.out.println("players Current champions" + p.getCurrentChampions());


//                    System.out.println();
//                    System.out.println("players Arena champions" + p.getArenaChampions());

//                    System.out.println("Buying move must be running right now");
                        isRound = true;


                    }

                }


                if(p.getBenchChampions().size()>9){

                    System.err.println("Your Bench is full, Please place some Champions to free some spaces in the Bench!!! ");
                    this.err=true;
                }

                break;

            }

            case (2):
            {

                System.out.println("2");
                System.out.println("Placing move must be running right now");




                boolean placeMove1 = false;

                if(p.getBenchChampions().size()==0){

                    System.err.println("You don't have any champion IN BENCH to place yet! you can buy some by pressing 1");
                }

                else{
                    System.out.println("Which champion do you want to place?");
                    ArrayList<Champion> championsToGetIndex = new ArrayList<Champion>();
                    championsToGetIndex = p.getBenchChampions();
                    System.out.println("Bench champions : " );
                    for (int l= 0 ; l <p.getBenchChampions().size() ; l++){
                        System.out.println(p.getBenchChampions().get(l) );
                        System.out.println();
                    }

//                    System.out.println("\n"+championsToGetIndex+"\n");
//                    System.out.println();
                    int indexOfChosenChampion;
                    indexOfChosenChampion = indexOfChosenChampionScanner.nextInt();
                    if(indexOfChosenChampion > championsToGetIndex.size()){
                        System.err.println("Please enter a right number ... from 1 ---> " + championsToGetIndex.size());
                        System.out.println("Bench champions : " );
                        for (int l= 0 ; l <p.getBenchChampions().size() ; l++){
                            System.out.println(p.getBenchChampions().get(l) );
                            System.out.println();
                        }
                        indexOfChosenChampion= indexOfChosenChampionScanner.nextInt();
                    }

                    int xCoor,yCoor;
                    System.out.println("Please write the coordinates you want to place your champion on: ");
                    System.out.print("X coordinate: ");
                    xCoor = xCoorScanner.nextInt();
                    System.out.println();
                    System.out.print("Y coordinate: ");
                    yCoor = yCoorScanner.nextInt();

                    //@TODO CHECK EXCEPTIONS HANDLING
//                    IllegalSquare.showErrorForConsole(championsToGetIndex.size());


                    PlaceMove move2  = new PlaceMove();
                placeMove1 = move2.placeMove(xCoor, yCoor, p.getBenchChampions().get(indexOfChosenChampion - 1), arena, indexOfPlayerToPrintItWithArena, p);
//                   System.out.println("she lazm estfed nno" + p.getBenchChampions().get(indexOfChosenChampion-1));

                   if(placeMove1){


                       Champion championToDeleteFromBench = new Champion();
                       championToDeleteFromBench =  p.getBenchChampions().get(indexOfChosenChampion-1);
                       p.getBenchChampions().remove(championToDeleteFromBench);
                       p.setArenaChampions(championToDeleteFromBench);
//                       System.out.println("player int placemove"+p.getPlayerIndex());
//                       System.out.println("player as palyer"+p);
//                       System.out.println("Arraylist as palyer"+indexOfPlayerToPrintItWithArena);
                       arena.printArena(p);

                   }



                    isRound = true;
                }
                break;
            }




            case (3):{



                if(phase2){
                    SellMove move1 = new SellMove();
                    Champion sell = new Champion();
                    if(wayOfPlanning==1){
                        sell =move1.printLisForSellMove(p,arena);
                        move1.PerformMove(p,arena,sell);
                    }
                    else {

                        sell = move1.printLisForSellMoveForAutoPlayer(p,arena);
                        move1.PerformMoveForAutoPlayer(p,arena,sell);
                    }

                    System.out.println("Selling move must be running right now");

                    break;
                }else {


                    System.out.println("Please enter a right number");
                    isRound=false;
                }


                break;


            }


            default:{
                System.out.println("Please enter a right number");
                isRound=false;

            }



        }

//        arena.printArena();
return isRound;
    }


   public  boolean AutoPlayerChoicesForPhase1( Player p, Arena arena, ArrayList<Player> indexOfPlayerToPrintItWithArena){
//        System.out.println(" PLAYER INDEX :: " + p.getPlayerIndex());
     //doing planning move for 3 times after each other
        for(int i =0 ; i<4;i++){
//            System.out.println(consoleGame.ConsoleColors.PURPLE_UNDERLINED+"Phase 1 is running, please choose your movement: "+ consoleGame.ConsoleColors.RESET);
//            System.out.println(consoleGame.ConsoleColors.CYAN_BOLD+"1-"+ consoleGame.ConsoleColors.RESET +" Buy champions.");
//            System.out.println(consoleGame.ConsoleColors.CYAN_BOLD+"2-"+ consoleGame.ConsoleColors.RESET +"Place your champions.");

            ArrayList<Champion> addedChampions = new ArrayList<Champion>();
            BuyMove move1 = new BuyMove();
            addedChampions = move1.doBuyingForAutoPlayer(5);
            p.getCurrentChampions().addAll(addedChampions);
            p.getBenchChampions().addAll(addedChampions);
            for(Champion c1 : addedChampions){

                c1.setPlayerId(p.getPlayerIndex());
//                System.err.println("champions with player id : "+c1.getPlayerId());


            }

            PlaceMove move2  = new PlaceMove();
            int xCoor = getRandom(0,13);
            int yCoor = getRandom(0,54);
//            System.out.println("x"+xCoor);
//            System.out.println("y:"+yCoor);
//

            boolean placeMove;
            placeMove = move2.placeMove(xCoor,yCoor,p.getBenchChampions().get(0),arena,indexOfPlayerToPrintItWithArena,p);
            if(placeMove){
                Champion championToDeleteFromBench = new Champion();
                championToDeleteFromBench =  p.getBenchChampions().get(0);
                p.getBenchChampions().remove(championToDeleteFromBench);
                p.setArenaChampions(championToDeleteFromBench);
//                       arena.printArena(p);

            }


        }

//       System.out.println(consoleGame.ConsoleColors.PURPLE_UNDERLINED+"Phase 1 is running, please choose your movement: "+ consoleGame.ConsoleColors.RESET);
//       System.out.println(consoleGame.ConsoleColors.CYAN_BOLD+"1-"+ consoleGame.ConsoleColors.RESET +" Buy champions.");
//       System.out.println(consoleGame.ConsoleColors.CYAN_BOLD+"2-"+ consoleGame.ConsoleColors.RESET +"Place your champions.");
//
//       ArrayList<Champion> addedChampions = new ArrayList<Champion>();
//       BuyMove move1 = new BuyMove();
//       addedChampions = move1.doBuyingForAutoPlayer(5);
//       p.getCurrentChampions().addAll(addedChampions);
//       p.getBenchChampions().addAll(addedChampions);
//       for(Champion c1 : addedChampions){
//
//           c1.setPlayerId(p.getPlayerIndex());
////                System.err.println("champions with player id : "+c1.getPlayerId());
//
//
//       }
        return true;
            }

    public     String  getChampionChoiceFromPhase2(int userChoice , Player player, Arena arena , ArrayList<Player> playersOfTheGame,Champion c,int wayOfPlanning){
        boolean isRound = false;
        String moveAsString =new String();


        switch (userChoice) {
            case (1): {

                moveAsString = moveAsString+"N";

                System.out.println("Selling move must be running right now");
                ExecuteMove executeMove = new ExecuteMove();
                executeMove.executeMove(moveAsString, arena,player , playersOfTheGame, wayOfPlanning);
                break;
            }

            case (2): {

                moveAsString = moveAsString+"W";
//                System.out.println("Please select the champion that you want to Move: ");
//                System.out.println(player.getArenaChampions());
//                int championToMove1;
//                championToMove1 =championToMove.nextInt();
//                System.out.println(championToMove1);
                String s =new String();
                s =c.championName.substring(0,3);

//                MoveFactory.creatMove(player.getArenaChampions().get(championToMove1),userChoice,arena,player,indexOfPlayerToPrintItWithArena);
                System.out.println("Walking move must be running right now");
                Scanner d = new Scanner(System.in);
                String id ;
                System.out.println("where did you want to move ? ");
                System.out.println(" 1-move up \n 2-move down \n 3-move left \n 4-move right");
                System.out.print("your choice :");
                id = d.next() ;

                moveAsString = moveAsString+s+id;
                System.out.println("move as string"+ moveAsString);
                ExecuteMove executeMove = new ExecuteMove();
                executeMove.executeMove(moveAsString, arena,player , playersOfTheGame, wayOfPlanning);
                break;
            }
            case (3): {

                moveAsString = moveAsString+"A";
                ArrayList<Champion> championGetsAttack = new ArrayList<Champion>();
//                System.out.println("Please select the champion you want to attack with: ");
//                System.out.println(player.getArenaChampions());
//                int championToAttackWith;
//                championToAttackWith =ChampionToAttackWith.nextInt();
                String championAsString = new String();
                championAsString= c.championName.substring(0,3);
                moveAsString = moveAsString+championAsString;



                System.out.println("The Champions on your Attack Range Are: ");

                BasicAttackMove move = new BasicAttackMove();
                championGetsAttack = move.attackAccepted(c,arena,player);
                if(championGetsAttack.size()!= 0) {

                    for(int i =0 ; i < championGetsAttack.size();i++){
                        System.out.println(consoleGame.ConsoleColors.YELLOW+"==========================================================================================================================================================================="+ consoleGame.ConsoleColors.RESET);
                        System.out.println(championGetsAttack.get(i));


                    }
                    System.out.println("Please choice a champion: ");
                    int championToBeAttacked;
                    championToBeAttacked = ChampionToBeAttacked.nextInt();


                    String championAsString2 = new String();
                    championAsString2 = championGetsAttack.get(championToBeAttacked - 1).championName.substring(0, 3);
                    moveAsString = moveAsString + championAsString2;

                    System.out.println(moveAsString);
                    ExecuteMove executeMove = new ExecuteMove();
                    executeMove.executeMove(moveAsString, arena,player , playersOfTheGame, wayOfPlanning);
                }


                else {
                    System.err.println("Sorry their is no champions on your attack range");
                    moveAsString="N";
                    break;
                }
                break;


            }
            case (4):
            {moveAsString = moveAsString+"B";
                System.out.println("Using Abilities move must be running right now");
//                System.out.println("==========================================================");
//                System.out.println("Please choose your champion : ");
//                System.out.println("your champions list is : ");
//
//
//               System.out.println(player.getArenaChampions());
//
//                System.out.println("your choice is : ");
//                int userChampionForUsingAbility= x1.nextInt();
                String useAbilityChampion = new String();
                useAbilityChampion =c.championName.substring(0,3);
                moveAsString = moveAsString+useAbilityChampion;
//                championsForPlan.add( player.getArenaChampions().get(userChampionForUsingAbility-1));
                ExecuteMove executeMove = new ExecuteMove();
                executeMove.executeMove(moveAsString, arena,player , playersOfTheGame, wayOfPlanning);
                break;




            }
            case (5):{
                moveAsString = moveAsString+"R";
                //swap
                System.out.println("swaaaaap");
                break;
            }
            case (6):{

                moveAsString = moveAsString+"N";
                break;

            }
            default:
                System.out.println("Please enter a right number");



        }
        return moveAsString;
    }


  //TODO make the execute move for auto player

    public     String AutoPlayerChampionChoiceFromPhase2(int userChoice , Player player, Arena arena , ArrayList<Player> playersOfTheGame,Champion c,int wayOfPlanning){
        boolean isRound = false;
        String moveAsString =new String();


        switch (userChoice) {
            case (1): {

                moveAsString = moveAsString+"N";
                ExecuteMove executeMove = new ExecuteMove();
                executeMove.executeMoveForAutoPlayer(moveAsString, arena,player , playersOfTheGame, wayOfPlanning);
                break;
            }

            case (2): {

                moveAsString = moveAsString+"W";

                String s =new String();
                s =c.championName.substring(0,3);
                int id = getRandom(1,4);

                System.err.println("the move is "+ id + "for champion " +c+"player "+ c.playerId);


                String idString= String.valueOf(id);
                moveAsString = moveAsString+s+idString;
                ExecuteMove executeMove = new ExecuteMove();
                executeMove.executeMoveForAutoPlayer(moveAsString, arena,player , playersOfTheGame, wayOfPlanning);
                break;
            }
            case (3): {

                moveAsString = moveAsString+"A";
                ArrayList<Champion> championGetsAttack = new ArrayList<Champion>();
                String championAsString = new String();
                championAsString= c.championName.substring(0,3);
                moveAsString = moveAsString+championAsString;




                BasicAttackMove move = new BasicAttackMove();
                championGetsAttack = move.attackAccepted(c,arena,player);
                if(championGetsAttack.size()!= 0) {
                    int championToBeAttacked = 1;
                    String championAsString2 = new String();
                    championAsString2 = championGetsAttack.get(championToBeAttacked - 1).championName.substring(0, 3);
                    moveAsString = moveAsString + championAsString2;
                    ExecuteMove executeMove = new ExecuteMove();
                    executeMove.executeMoveForAutoPlayer(moveAsString, arena,player , playersOfTheGame, wayOfPlanning);
                }


                else {
                    moveAsString="N";
                    break;
                }
                break;


            }
            case (4):
            {moveAsString = moveAsString+"B";
                String useAbilityChampion = new String();
                useAbilityChampion =c.championName.substring(0,3);
                moveAsString = moveAsString+useAbilityChampion;
                ExecuteMove executeMove = new ExecuteMove();
                executeMove.executeMoveForAutoPlayer(moveAsString, arena,player , playersOfTheGame, wayOfPlanning);
                break;




            }
            case (5):{
                moveAsString = moveAsString+"R";
                //swap
                break;
            }
            case (6):{

                moveAsString = moveAsString+"N";
                break;

            }
            default:
                System.out.println("Please enter a right number");



        }
        return moveAsString;
    }

    public static void main(String[] args) {
        Planning p= new Planning();
//        p.AutoPlayerChoicesForPhase1(5);
//        p.planningMethod();

    }


}
