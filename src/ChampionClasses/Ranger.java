package ChampionClasses;

import Champion.Champion;
import Player.Player;

public class Ranger {
    public Champion ActiveAbilityFromClasses(Champion c , int numberOfChampions){
        if(numberOfChampions >=3) {
            c.AttackRange=c.AttackRange*2;
        }
        return c;

    }
}

