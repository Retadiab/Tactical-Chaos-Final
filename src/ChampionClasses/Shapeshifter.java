package ChampionClasses;

import Champion.Champion;
import Player.Player;

public class Shapeshifter {
    public Champion ActiveAbilityFromClasses(Champion c , int numberOfChampions){
        if(numberOfChampions >=3&&numberOfChampions>6) {
            c.health=c.health+4;
        }
        if(numberOfChampions==6) {
            c.health=c.health+10;
        }
        return c;

    }
}

