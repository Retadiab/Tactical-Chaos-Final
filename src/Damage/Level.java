package Damage;
import Champion.* ;
public class Level {

// make champion level 2
    public static void Level2 (Champion champion)  {
        //amplifying  basic attack by 10%
        champion.setBasicAttack((float) (champion.getBasicAttack() + ((champion.getBasicAttack() * 0.1 ))));
        //amplifying  armor by 20%
        champion.setMagicR((float) (champion.getMagicR() + (champion.getMagicR() * 0.20)));
        //amplifying magic resist by 20%
        champion.setArmor((float) (champion.getArmor() + (champion.getArmor() * 0.20) ));
    }
    public static void Level3(Champion champion) {
        //amplifying  basic attack by 15%
        champion.setBasicAttack((float) (champion.getBasicAttack() + ((champion.getBasicAttack() * 0.15 ))));
        //amplifying  armor by 25%
        champion.setMagicR((float) (champion.getMagicR() + (champion.getMagicR() * 0.25)));
        //amplifying magic resist by 25%
        champion.setArmor((float) (champion.getArmor() + (champion.getArmor() * 0.25) ));

    }
    //when champion level up we need to remove the three level 1/2 champion before put one new level 2/3 champion
}
