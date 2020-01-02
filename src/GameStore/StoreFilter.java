package GameStore;

import Champion.Champion;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public abstract class  StoreFilter {


    public InGameStore myGameStore = new InGameStore();

    ArrayList<Champion> myChampions = new ArrayList<Champion>();

  public StoreFilter decoratedStoreFilter;


    public ArrayList<Champion> GetChampionsList() {


        myChampions = myGameStore.championList();
        return myChampions;




    }

    protected StoreFilter storeFilter(StoreFilter storefilter) {
        return storefilter;
    }









//    public static void  main(String[] args) {
//         ArrayList<Champion> championsList1 = new ArrayList<Champion>();
//
//        StoreFilter f = new StoreFilter();
//
//
//        championsList1 = f.GetChampionsList();
//        for(int i = 0 ; i< championsList1.size() ; i++) {
//            System.out.println("==============================================");
//            System.out.print(i);
//            System.out.print(championsList1.get(i));
//        }
//
//    }
}
