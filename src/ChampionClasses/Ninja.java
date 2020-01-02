package ChampionClasses;

import Champion.Champion;

public class Ninja {
    public Champion ActiveAbilityFromClasses(Champion c , int numberOfChampions){
        if(numberOfChampions >=1){
            c.CriticalDamage=c.CriticalDamage+20;
            c.CriticalChance=c.CriticalChance+5;

            //just edit the attributes in champion
        }
        return c;
    }}
