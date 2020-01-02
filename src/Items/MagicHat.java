package Items;

import Champion.Champion;

public class MagicHat extends Item {
    public String name = "MagicHat";
    public float x = (float) 0.2;
    public String Class = "sorcerer";


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
