package Damage;
import Champion.*;
public class DamageMana implements IDamage {
    @Override
    //func deal with any damage to Champion's Mana without any shild
    public void Damaged(Champion champion, float Mana) {
        champion.setMana(champion.getMana() - Mana );
    }
}
