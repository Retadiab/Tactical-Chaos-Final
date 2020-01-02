package Items;

import Champion.Champion;

public class UniverseCore extends Item {
    public String name = "UniverseCore";
    public float x = (float)0.2;
    public String Class = "elementalist";

    @Override
    public void equip(Champion champion) {
float y = champion.MagicResist * x ;
champion.MagicResist = champion.MagicResist + y ;
    }

    @Override
    public void unquip(Champion champion) {
        float y = champion.MagicResist * x ;
        champion.MagicResist = champion.MagicResist - y ;
    }
}
