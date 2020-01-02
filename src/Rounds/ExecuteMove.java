package Rounds;

import Arena.Arena;
import Champion.Champion;
import GameStore.TemporalStoreFilter;
import Move.*;
import Player.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class ExecuteMove extends Round {




    static Scanner x1 =new Scanner(System.in);
    static Scanner championToMove =new Scanner(System.in);

    private boolean err =false;
    static Scanner x =new Scanner(System.in);
//    static Scanner x1 =new Scanner(System.in);
    static Scanner x2 =new Scanner(System.in);
    static Scanner indexOfChosenChampionScanner =new Scanner(System.in);
    static Scanner xCoorScanner = new Scanner(System.in);
    static Scanner yCoorScanner = new Scanner(System.in);
ArrayList<String> plan = new ArrayList<String>();
//    public boolean getChampionChoiceFromPhase2(int userChoice , Player player, Arena arena , ArrayList<Player> indexOfPlayerToPrintItWithArena,boolean execute){
//        boolean isRound = false;
//
//
//        switch (userChoice) {
//
//            case (1): {
////                SellMove move1 = new SellMove();
//                System.out.println("Selling move must be running right now");
//
//                break;
//            }
//
//
//
//
//            case (2): {
////                BuyMove move2 = new BuyMove();
//
//                ///ro7y jebeha mn hnek
//                System.out.println("Buying move must be running right now");
//                TemporalStoreFilter tempStore = new TemporalStoreFilter();
//
//                ArrayList<Champion> addedChampions = new ArrayList<Champion>();
//                BuyMove move1 = new BuyMove();
//
////                System.out.println(addedChampions);
//                if(player.getBenchChampions().size()<=9) {
//                    if(player.getBenchChampions().size()==9){
//                        System.err.println("Your Bench is full, Please place some Champions to free some spaces in the Bench!!! ");
//                        this.err=true;
//                        break;
//                    }
//                    System.out.println("champions array size"+player.getBenchChampions().size());
//                    addedChampions = move1.doBuying(5);
//                    String planForBuying = new String();
//                    planForBuying= "BuyChampions:  ";
//                    for(int i1 =0 ; i1 <addedChampions.size(); i1++)
//                    {
//                       planForBuying = planForBuying + addedChampions.get(i1).toString()+"\n";
//                    }
//                    System.out.println(planForBuying);
//                    plan.add(planForBuying);
//                    if(execute){
//                        player.getCurrentChampions().addAll(addedChampions);
//                        player.getBenchChampions().addAll(addedChampions);
//                        isRound = true;
//                    }
//
//
//                }
//
//
//
//                if(player.getBenchChampions().size()>9){
//
//                    System.err.println("Your Bench is full, Please place some Champions to free some spaces in the Bench!!! ");
//                    this.err=true;
//                }
//
//                break;
//
//
//
//
//            }
//            case (3): {
//
//
//                System.out.println("Please select the champion that you want to Move: ");
//                System.out.println(player.getArenaChampions());
//                int championToMove1;
//                championToMove1 =championToMove.nextInt();
//                System.out.println(championToMove1);
//                MoveFactory.creatMove(player.getArenaChampions().get(championToMove1),userChoice,arena,player,indexOfPlayerToPrintItWithArena);
//                System.out.println("Walking move must be running right now");
//
//                break;
//
//
//            }
//            case (4): {
//
//                BasicAttackMove move4 = new BasicAttackMove();
//                System.out.println("BasicAttack move must be running right now");
//
//                break;
//
//
//            }
//            case (5):
//            {
//                System.out.println("UsingAbilities move must be running right now");
//                System.out.println("==========================================================");
//
//                System.out.println("Please enter ID of one of your champions : ");
//                System.out.println("your champion list is : ");
//
////                for(int i =0 ; i<currentChampions.size(); i++){
////                                    //get currentChampions from the player class
////                //consolePlayer.CurrentChampions
////                }
//                System.out.println("your choice is : ");
//
//                int userChampionFor= x1.nextInt();
//
//                Champion championToUseAbility = new Champion();
//                //championToUseAbility = consolePlayer.CurrentChampions.get(userChampionFor-1);
//
//                ActivateFioraAbilityMove move6 = new ActivateFioraAbilityMove();
//
//
//
//                break;
//
//
//
//
//            }
//            case (6):{
//
//                System.out.println("Placing move must be running right now");
//
//
//
//
//                boolean placeMove = false;
//
//                if(player.getBenchChampions().size()==0){
//
//                    System.err.println("You don't have any champion IN BENCH to place yet! you can buy some by pressing 1");
//                }
//
//                else{
//                    System.out.println("Which champion do you want to place?");
//                    ArrayList<Champion> championsToGetIndex = new ArrayList<Champion>();
//                    championsToGetIndex = player.getBenchChampions();
//                    System.out.println("Bench champions : " );
//                    for (int l= 0 ; l <player.getBenchChampions().size() ; l++){
//                        System.out.println(player.getBenchChampions().get(l) );
//                        System.out.println();
//                    }
//
////                    System.out.println("\n"+championsToGetIndex+"\n");
////                    System.out.println();
//                    int indexOfChosenChampion;
//                    indexOfChosenChampion = indexOfChosenChampionScanner.nextInt();
//                    if(indexOfChosenChampion > championsToGetIndex.size()){
//                        System.err.println("Please enter a right number ... from 1 ---> " + championsToGetIndex.size());
//                        System.out.println("Bench champions : " );
//                        for (int l= 0 ; l <player.getBenchChampions().size() ; l++){
//                            System.out.println(player.getBenchChampions().get(l) );
//                            System.out.println();
//                        }
//                        indexOfChosenChampion= indexOfChosenChampionScanner.nextInt();
//                    }
//
//                    int xCoor,yCoor;
//                    System.out.println("Please write the coordinates you want to place your champion on: ");
//                    System.out.print("X coordinate: ");
//                    xCoor = xCoorScanner.nextInt();
//                    System.out.println();
//                    System.out.print("Y coordinate: ");
//                    yCoor = yCoorScanner.nextInt();
//
//
//
//                    PlaceMove move2  = new PlaceMove();
//
//                    placeMove = move2.placeMove(xCoor,yCoor,player.getBenchChampions().get(indexOfChosenChampion-1),arena,indexOfPlayerToPrintItWithArena,player);
////                   System.out.println("she lazm estfed nno" + p.getBenchChampions().get(indexOfChosenChampion-1));
//                    if(placeMove){
//
//
//                        Champion championToDeleteFromBench = new Champion();
//                        championToDeleteFromBench =  player.getBenchChampions().get(indexOfChosenChampion-1);
//                        player.getBenchChampions().remove(championToDeleteFromBench);
//                        player.setArenaChampions(championToDeleteFromBench);
//                        System.out.println("player int placemove"+player.getPlayerIndex());
//                        System.out.println("player as palyer"+player);
//                        System.out.println("Arraylist as palyer"+indexOfPlayerToPrintItWithArena);
//                        arena.printArena(player,indexOfPlayerToPrintItWithArena);
//
//                    }
//
//
//
//                    isRound = true;
//                }
//                break;
//            }
//            default:
//                System.out.println("Please enter a right number");
//
//
//
//        }
//        return isRound;
//
//    }









    public boolean executeMove (String plan  , Arena arena , Player p1 , ArrayList<Player> players,int wayOfPlaying){


      boolean done = false;

//      System.out.println("plan size" + plan.size());
//        for(int i =0 ; i <plan.size(); i++){
//
//            String move = new String();
//            move = plan.get(i).substring(0,1);
        String move = new String();
        move = plan.substring(0,1);
            switch (move){

                case "T":{

                    done = true;

                }
                case "W":{

                    System.out.println("Walk move must be runing right now ");

                    boolean championIsHere = false;

                    String parameters = new String();
//                    parameters =plan.get(i);
                    parameters =plan;
                    Champion championForTheMove =new Champion();

                    parameters.substring(1,3);
                    for(Champion c : p1.getArenaChampions()){
                        if(c.getChampionName() != null && c.getChampionName().substring(0,3).contains(parameters.substring(1,4)))
                        {
                           championForTheMove = c;
                            championIsHere=true;
                        }

                    }

                    if(!championIsHere){

                        System.err.println("Sorry your champion is not exist any more");
                    }
                    WalkMove move1 = new WalkMove();

                    done=move1.PerformMove(championForTheMove , Integer.parseInt(parameters.substring(4,5)) , arena,p1,players);
                        break;
                }

                case "A":

                    {



                        System.out.println("Attack move must be runing right now ");

                        String parametersA = new String();

                        boolean championIsHere = false;
                        boolean championIsHere1 = false;
                        Champion Attacker =new Champion();
                        Champion Target =new Champion();

//                        parametersA =plan.get(i);
                        parametersA =plan;

                        parametersA.substring(1,4);



                        for(Champion c : p1.getArenaChampions()){
                            if(c.getChampionName() != null && c.getChampionName().substring(0,3).equals(parametersA.substring(1,4)))
                            {
                                Attacker=c;
                                championIsHere1 =true;

                            }

                        }
                        if(!championIsHere1){

                            System.err.println("Something went wrong maybe your attacker champion got killed !!! :( ");
                        }

                        System.out.println("champions on arena " +arena.getAllChampionsOnArena());

                        for(Champion c : arena.getAllChampionsOnArena()){
                            if(c.getChampionName() != null && c.getChampionName().substring(0,3).equals(parametersA.substring(4,7)))
                            {
                                Target=c;
                                championIsHere =true;
                            }
                        }
                        if(!championIsHere){

                            System.err.println("Something went Wrong maybe your Target is already dead!!! :( ");

                            done =true;
                            break;
                        }
                        else {

                            BasicAttackMove move2 = new BasicAttackMove();
                            boolean n = false;
                            n = move2.PerformMove(Attacker, Target);
                            if (!n) {

                                System.err.println("Sorry your Attack got canceled :( !!! ");
                            }
                        }
                        done =true;
                        break;



                     }

                case "B": {
                    System.out.println("Ability move must be runing right now ");

                    String parametersB = new String();

                    boolean championIsHere = false;

                    Champion championToUseAbility =new Champion();

//                    parametersB =plan.get(i);
                    parametersB =plan;
                    parametersB.substring(1,4);
                    for(Champion c : p1.getArenaChampions()){
                        if(c.getChampionName() != null && c.getChampionName().substring(0,3).contains(parametersB.substring(1,4)))
                        {
                            championToUseAbility=c;
                            championIsHere=true;
                        }
                    }
                    if(!championIsHere){
                        System.err.println("Your champion is dead you can not use his/her ability anymore !!! ");
                        done = true;
                        break;
                    }
                    else {
                    MoveFactory moveAbility =new MoveFactory();
                    moveAbility.createAbilityMove(championToUseAbility,arena,p1,players);


                    }
                    done = true;
                    break;

                }
                case "P":{
                    done = true;

                    break;

                }

                case "R":{
                    done = true;
                    break;

                }
                case "N":{
                    done=true;
                    break;
                }



            }


        return done;

        }









    public static void main(String[] args) {
        ExecuteMove x = new ExecuteMove();
        ArrayList<String> s = new ArrayList<String>();
        s.add("WAat4");
//        x.executeMove(s,null,null,null);
    }



}
