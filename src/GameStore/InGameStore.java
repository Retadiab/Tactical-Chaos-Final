package GameStore;

import Champion.Champion;

import java.util.ArrayList;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class  InGameStore {
    protected StoreFilter decoratedStoreFilter;

    static ArrayList<String> championsList = new ArrayList<String>();
    public ArrayList<String> c = new ArrayList<String>();
    private float[] floatAttributes = new float[50];

    private  int championId;
    private int int1 ;
    public String str;
    public  ArrayList<String>  readChampionFromFile() {

        ReadFileLineByLineUsingBufferedReader myFile = new ReadFileLineByLineUsingBufferedReader();
        this.championsList = ReadFileLineByLineUsingBufferedReader.readFile();

        return this.championsList;
        //        System.out.println(this.sequence);

    }

    public Champion readChampion(String championAsString){
        String[] champion = championAsString.split(",");
//System.out.println(championAsString);
//        for (int l =0 ; l<champion.length; l++)
//        {
//
////    System.out.println(champion[l]);
//        }


        this.int1= parseInt(champion[4]);

//    System.out.println("44444444444444444444444"+this.int1);

        String string =new String();
//        String[] array1 = array1.champion[i].split(",");

        float f = parseFloat(champion[5]);
//    System.out.println("5555555555555555555555555555555"+f);
        int j =0 ;
        for (int i = 5; i < champion.length-2; i++) {
            floatAttributes[j] = parseFloat(champion[i]);
//            System.out.println("floate addddd"+floatAttributes[j]);
            j++;


        }


        int len = champion.length;
        this.championId = parseInt(champion[17]);

        Champion championToReturn = new Champion(
                champion[0],
                champion[1],
                champion[2],
                champion[3],
                this.int1,
                floatAttributes[0],
                floatAttributes[1],
                floatAttributes[2],
                floatAttributes[3],
                floatAttributes[4],
                floatAttributes[5],
                floatAttributes[6],
                floatAttributes[7],
                floatAttributes[8],
                floatAttributes[9],
                floatAttributes[10],
                champion[16],
                this.championId);

        return  championToReturn;

    }


    //
    public ArrayList<Champion>  championList(){
        ArrayList<String> championsList1 = new ArrayList<String>();
        championsList1 = readChampionFromFile();
        ArrayList<Champion> championsList = new ArrayList<Champion>();

        for(int i1 =1 ; i1< championsList1.size() ; i1++ )
        {



            Champion c;


            c= readChampion(championsList1.get(i1));

            championsList.add(i1-1,c);


        }
        return  championsList ;

    }

//
//    public static void main(String[] args) {
//        InGameStore  mu = new InGameStore();
//        ArrayList<Champion> championsList= new ArrayList<Champion>();
//
//
//        championsList = mu.championList();
//        System.out.print(championsList.get(2).toInitials());
//
////        for(int i = 0 ; i< championsList.size() ; i++) {
////            System.out.println("==============================================");
////            System.out.print(i);
////            System.out.print(championsList.get(i));
////        }
//    }



}
