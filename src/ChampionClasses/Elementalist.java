package ChampionClasses;

import Champion.Champion;
import Damage.DamageCalculatorFactory;
import Player.Player;

public class Elementalist {
    public Champion ActiveAbilityFromClasses(Champion c , int numberOfChampions){
        if(numberOfChampions ==2||numberOfChampions ==3) {
                c.ManaStart=c.ManaStart*2;
            }
        return c;

    }
}
