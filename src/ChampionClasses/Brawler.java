package ChampionClasses;

import Champion.Champion;
import Player.Player;

public class Brawler {
    public Champion ActiveAbilityFromClasses(Champion c , int numberOfChampions, Player player){

        if(numberOfChampions ==2||numberOfChampions ==3){
            for (int i = 0 ; i <= player.getCurrentChampions().size() ; i++) {
                player.getCurrentChampions().get(i).health=player.getCurrentChampions().get(i).health+250;


            }
            //just edit the attributes in champion
        }
        if(numberOfChampions ==4||numberOfChampions ==5){
            for (int i = 0 ; i <= player.getCurrentChampions().size() ; i++) {
                player.getCurrentChampions().get(i).health=player.getCurrentChampions().get(i).health+500;


            }
            //just edit the attributes in champion
        }
        if(numberOfChampions ==6){
            for (int i = 0 ; i <= player.getCurrentChampions().size() ; i++) {
                player.getCurrentChampions().get(i).health=player.getCurrentChampions().get(i).health+1000;


            }
            //just edit the attributes in champion
        }
        return c;
    }
}

