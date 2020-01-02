package Items;

import Champion.Champion;

public class KnightArmor extends Item {
    public String name = "KnightArmor";
    public float x = (float) 0.15;
    public String Class = "Knight" ;
    @Override
    public void equip(Champion champion) {
        float y = champion.Armor * x ;
        champion.Armor = champion.Armor + y ;
    }

    @Override
    public void unquip(Champion champion) {
        float y = champion.Armor * x ;
        champion.Armor = champion.Armor - y ;
    }
}
