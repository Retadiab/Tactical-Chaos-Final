package Items;

import Champion.Champion;

public class WarriorGloves extends Item {
    public String name = "WarriorGloves";
    public float x = (float) 0.1;
    public String Class = "blade master";
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
