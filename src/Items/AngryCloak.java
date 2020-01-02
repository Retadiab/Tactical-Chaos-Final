package Items;

import Champion.Champion;

public class AngryCloak extends Item {
    public String name = "AngryCloak";
    float x = (float)0.1 ;
    public String Class = "yordle" ;


    @Override
    public void equip(Champion champion) {
       float y = champion.CriticalDamage * x ;
       champion.CriticalDamage=champion.CriticalDamage + y ;
    }

    @Override
    public void unquip(Champion champion) {
        float y = champion.CriticalDamage * x ;
        champion.CriticalDamage=champion.CriticalDamage - y ;
    }
}
