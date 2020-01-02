package ChampionClasses;

import Champion.Champion;
import Damage.DamageCalculatorFactory;
import Player.Player;

public class Noble {
    public Champion ActiveAbilityFromClasses(Champion c , int numberOfChampions, Champion Target, Player player){
        if(numberOfChampions >=3&& numberOfChampions<6){
            Target.Armor=Target.Armor+2;
            //just edit the attributes in champion
        }
        if(numberOfChampions >=6){
            for (int i = 0 ; i <= player.getCurrentChampions().size() ; i++)
                player.getCurrentChampions().get(i).Armor=player.getCurrentChampions().get(i).Armor+2;
            //just edit the attributes in champion
        }
        return c;
    }}