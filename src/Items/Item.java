package Items;

import Champion.Champion;

public abstract class Item  {

    public int x ;
    public int y ;
    public abstract void equip(Champion champion);
    public abstract void unquip(Champion champion);

}
