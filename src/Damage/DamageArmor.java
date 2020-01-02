package Damage;
import Champion.*;
public class DamageArmor extends DamageDecorator {
    public DamageArmor(IDamage damage) {
        super(damage);
    }


// func deal with damage to champion's health with Armor
    public void Damaged(Champion champion , float much ){
        float AttackAfterShilding = champion.getArmor() * much ;
        System.out.println("champion before getting attacked : "+champion.health);
        this.damage.Damaged(champion, much - AttackAfterShilding  );
        System.out.println("champion after getting attacked : "+champion.health);
    }
}
