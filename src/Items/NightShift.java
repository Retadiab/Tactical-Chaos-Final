package Items;

import Champion.Champion;

public class NightShift extends Item {
    public String name = "NightShift";
    public float x = (float) 0.2;
    public String Class = "assassin";



    @Override
    public void equip(Champion champion) {
        float y = champion.AttackDamage * x ;
        champion.AttackDamage = champion.AttackDamage + y ;

    }

    @Override
    public void unquip(Champion champion) {
        float y = champion.AttackDamage * x ;
        champion.AttackDamage = champion.AttackDamage - y ;
    }
}
