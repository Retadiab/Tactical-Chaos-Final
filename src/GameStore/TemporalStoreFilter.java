package GameStore;

import Champion.Champion;
import Game.consoleGame;
import Move.BuyMove;
import Player.Player;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TemporalStoreFilter extends StoreFilter {
    public  static Random r =new Random();
    static Scanner pickedChampionScanner =new Scanner(System.in);


    public  ArrayList<Champion> getChampionsForTempStore() {
        return championsForTempStore;
    }



    //championsForTempStore has got the 10 copies of each champion ,
    ArrayList<Champion> championsForTempStore =new ArrayList<Champion>();


    public  ArrayList<Champion> getChampionsForTempStore1() {
        return championsForTempStore1;
    }

    //championsForTempStore1 getting random 5 elements from the championsForTempStore tah got 10 copies  ,
     ArrayList<Champion> championsForTempStore1 =new ArrayList<Champion>();



   //Player choices from the championsForTempStore1 that got 5 random champions
   static ArrayList<Integer> championChoices =new ArrayList<Integer>();


   private int IndexToDelete = 0 ;

   //The Real indexes of the champion's choices to remove it from the main list that got 10 copies
    static ArrayList<Integer> IndexesToDelete =new ArrayList<Integer>();

    BuyMove move = new BuyMove();




    //random champion from the list
    public  Champion getRandomChestItem(ArrayList<Champion> items) {
        this.IndexToDelete = new Random().nextInt(items.size());
        return items.get(this.IndexToDelete);
    }


    //this championsListFromStore is for getting the array from exel file
    private ArrayList<Champion> championsListFromStore = new ArrayList<Champion>();


    //this method is for getting the choices from Player and store them in Arraylist of integers
    public ArrayList<Integer> GetOnly(int championsNumber) {
        this.championChoices.clear();
        championsListFromStore = GetChampionsList();
        int championList = 47, copyOfEachChampionInMainStore = 10;

            for (int i = 1; i < championList ; i++) {
                for (int j = 0; j < copyOfEachChampionInMainStore; j++) {
                    Champion champ = new Champion();
                    championsForTempStore.add(championsListFromStore.get(i));
                }

            }


//            System.out.println(championsForTempStore);
        for(int i1=0 ; i1<championsNumber ;i1++){
            championsForTempStore1.add(getRandomChestItem(championsForTempStore));
          IndexesToDelete.add(this.IndexToDelete);

            System.out.print(consoleGame.ConsoleColors.YELLOW+(i1+1)+"||\t"+ consoleGame.ConsoleColors.RESET);
            System.out.println(championsForTempStore1.get(i1));
            System.out.println(consoleGame.ConsoleColors.YELLOW+"==========================================================================================================================================================================="+ consoleGame.ConsoleColors.RESET);
        }



        int counter=0;

        while(counter < 3 ) {

            System.out.println("Please Enter Your choice  :  -------IF YOU DON'T WANT TO ADD MORE CHAMPIONS PRESS ***0***------ ");

            int pickedChampion;
            pickedChampion = pickedChampionScanner.nextInt();


            if(pickedChampion == 0 ){

                break;
            }
            else if(pickedChampion >5 || pickedChampion<0){
                System.out.println("Please enter a number between 1 -> 5 ");
            }
            else if(championChoices.contains(pickedChampion)){

                System.err.println("You have Already chosen this Champion , Please Pick Another One.. ");
            }
            else{
                championChoices.add(pickedChampion);
                int x =IndexesToDelete.get(pickedChampion-1);
                championsForTempStore.remove(x);
                System.out.println("Your champion Has been Added successfully! ");
                counter = counter+1;
            }
               }

//        System.out.println(championChoices);

        return championChoices;
    }


    public  ArrayList<Integer> GetOnlyForAutoPlayer(int championsNumber)  {
//        this.championChoices.clear();
        championsListFromStore = GetChampionsList();
        int championList = 47, copyOfEachChampionInMainStore = 10;

        for (int i = 1; i < championList ; i++) {
            for (int j = 0; j < copyOfEachChampionInMainStore; j++) {
                Champion champ = new Champion();
                championsForTempStore.add(championsListFromStore.get(i));
            }

        }


//            System.out.println(championsForTempStore);
        for(int i1=0 ; i1<championsNumber ;i1++) {
            championsForTempStore1.add(getRandomChestItem(championsForTempStore));
            IndexesToDelete.add(this.IndexToDelete);

//            System.out.print(consoleGame.ConsoleColors.YELLOW+(i1+1)+"||\t"+ consoleGame.ConsoleColors.RESET);
//            System.out.println(championsForTempStore1.get(i1));
//            System.out.println(consoleGame.ConsoleColors.YELLOW+"==========================================================================================================================================================================="+ consoleGame.ConsoleColors.RESET);
        }


        int counter=0;
        ArrayList<Integer> PickedChampion= new ArrayList<Integer>();
        PickedChampion.add(1);
        PickedChampion.add(0);

        int pickedChampion;
//        while(counter < 3 ) {

            for(int i=0 ; i<2 ;i++){
//                System.out.println("Please Enter Your choice  :  -------IF YOU DON'T WANT TO ADD MORE CHAMPIONS PRESS ***0***------ ");

                pickedChampion = PickedChampion.get(i);
                if(pickedChampion == 0 ){
                    PickedChampion.remove(i);
                    break;
                }
//                System.out.println(consoleGame.ConsoleColors.GREEN+pickedChampion+ consoleGame.ConsoleColors.RESET);
                championChoices.add(pickedChampion);
//                System.out.println("Your champion Has been Added successfully! ");

                int x =IndexesToDelete.get(pickedChampion-1);
                championsForTempStore.remove(x);

    }
//        System.out.println("Please Enter Your choice  :  -------IF YOU DON'T WANT TO ADD MORE CHAMPIONS PRESS ***0***------ ");
//        System.out.println(consoleGame.ConsoleColors.GREEN+"0"+ consoleGame.ConsoleColors.RESET);

        return PickedChampion;

    }






    public ArrayList<Champion> GetOnlyForGUI(){


        championsListFromStore = GetChampionsList();
        int championList = 47, copyOfEachChampionInMainStore = 10;
        ArrayList <Champion> mainstore;


        for (int i = 1; i < championList ; i++) {
            for (int j = 0; j < copyOfEachChampionInMainStore; j++) {
                Champion champ = new Champion();
                championsForTempStore.add(championsListFromStore.get(i));
            }

        }


//            System.out.println(championsForTempStore);
        for(int i1=0 ; i1<5 ;i1++){
            championsForTempStore1.add(getRandomChestItem(championsForTempStore));
            IndexesToDelete.add(this.IndexToDelete);

        }


        return championsForTempStore1;

    }


    public static void main(String[] args) {
        TemporalStoreFilter Store = new TemporalStoreFilter();
        Store.GetOnly(5);
    }


}
