package ChampionClasses;

import Champion.Champion;
import Player.Player;

public class Assassin {
    public Champion ActiveAbilityFromClasses(Champion c , int numberOfChampions){
        if(numberOfChampions >=2&&numberOfChampions<4){
            c.AttackDamage=c.AttackDamage+30;

            //just edit the attributes in champion
        }
        if(numberOfChampions >=4){
            c.AttackDamage=c.AttackDamage+60;
            //just edit the attributes in champion
        }

return c;
    }
}

