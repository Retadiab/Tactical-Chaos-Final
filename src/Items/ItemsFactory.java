package Items;

import Champion.Champion;
import ChampionClasses.Void;

public  class ItemsFactory {   // lazm al random mn al 1 -> 7
    public static Item getItem(int x){
        switch (x){
            case(1):{
                MagicHat item = new MagicHat();
                return item ;}
            case (2):{
                AngryCloak item = new AngryCloak();
                return item; }
            case (3): {
                KnightArmor item = new KnightArmor();
                return item; }
            case(4):{
                NightShift item = new NightShift();
                return item; }
            case(5):{
                UniverseCore item = new UniverseCore();
                return item ; }
            case(6):{
                VoidHit item = new VoidHit();
                return item; }
            case(7):{
                WarriorGloves item = new WarriorGloves();
                return item ;}

            default:
                throw new IllegalStateException("Unexpected value: " + x);
        }

    }
}
