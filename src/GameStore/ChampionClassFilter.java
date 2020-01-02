package GameStore;

import Champion.Champion;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class ChampionClassFilter extends StoreFilter {



    public ArrayList<Champion> championsListForStore = new ArrayList<Champion>();


    ArrayList<Champion> FilteredChampionsByType(String championType) {
        ArrayList<Champion> FilteredChampionsByType =new ArrayList<Champion>();
        championsListForStore = GetChampionsList();


        for(int i=0; i< championsListForStore.size() ; i++ ) {




            if (
                    (championsListForStore.get(i).championClass3.equals(championType)) ||
                            (championsListForStore.get(i).championClass2.equals(championType))||
                            (championsListForStore.get(i).championClass1.equals(championType))



            ) {


      FilteredChampionsByType.add(championsListForStore.get(i));


            }
        }


return FilteredChampionsByType;

    }


//    public static void main(String[] args) {
//        ChampionClassFilter s = new ChampionClassFilter();
//        s.FilteredChampionsByType("BladeMaster");
//    }
}
