package Items;

import Champion.Champion;

public class VoidHit extends Item {
    public String name = "VoidHit";
    public float x = (float) 0.05;
    public String Class = "void";
    @Override
    public void equip(Champion champion) {
      float y = champion.maxhealth * x ;
      champion.health= champion.health + y;
    }

    @Override
    public void unquip(Champion champion) {
        float y = champion.maxhealth * x ;
        champion.health= champion.health - y;
    }
}
