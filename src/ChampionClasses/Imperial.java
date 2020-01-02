package ChampionClasses;

import Champion.Champion;
import Damage.DamageCalculatorFactory;

public class Imperial {
    public Champion ActiveAbilityFromClasses(Champion c , int numberOfChampions){
        if(numberOfChampions >=2){
            c.AttackDamage=c.AttackDamage*2;

            //just edit the attributes in champion
        }
        return c;
    }}