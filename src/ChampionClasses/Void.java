package ChampionClasses;

import Champion.Champion;
import Player.Player;

public class Void {
    public Champion ActiveAbilityFromClasses(Champion c , int numberOfChampions, Champion Target, Player player){
        if(numberOfChampions ==2||numberOfChampions ==3){
            Target.MagicResist=0;
            Target.Armor=0;
            //just edit the attributes in champion
        }
        if(numberOfChampions >=4){
            for (int i = 0 ; i <= player.getCurrentChampions().size() ; i++){
                player.getCurrentChampions().get(i).MagicResist=0;
                player.getCurrentChampions().get(i).Armor=0;
                //just edit the attributes in champion
        }}
        return c;
    }}

