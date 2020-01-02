package Damage;
import Champion.*;
public class DamageAttack implements IDamage {

    @Override
    //func deal with Damage to champion's health without any shild
    public void Damaged(Champion champion , float Attack) {

        champion.setHealth(champion.getHealth() -  Attack );

    }
}
