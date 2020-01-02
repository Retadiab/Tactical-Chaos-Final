package Damage;
import Champion.*;
public class DamageAbility extends DamageDecorator {
    public DamageAbility(IDamage damage) {
        super(damage);
    }
    //func deal with champion's health with MagicR  (Damage from enemy champion's ability)
    public void Damaged(Champion champion , float much) {
       float AttackAftershilding =  much * champion.getMagicR() ;
        this.damage.Damaged(champion,   much - AttackAftershilding  );
    }
}
