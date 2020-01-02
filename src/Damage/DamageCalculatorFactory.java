package Damage;
import Champion.*;

public class DamageCalculatorFactory {
    /*
   1-Damage to the health without shield
   2-Damage to the health with Armor
   3-Damage to the health from Ability
   4-Damage to the Mana
      */




  public static void creatDamageCalculator(Champion champion , int id , float much) {
      switch (id ) {
         case (1):{
            IDamage damage = new DamageAttack();
            damage.Damaged(champion, much);
            System.out.println("hi from case 1 ");
            break;}

         case (2):{
            IDamage damage = new DamageArmor(new DamageAttack());
            damage.Damaged(champion, much);
            System.out.println("hi from case 2 ");
            break;}

         case (3) :{
            IDamage damage = new DamageAbility(new DamageAttack());
            damage.Damaged(champion, much);
            System.out.println("hi from case 3 ");
          break;}
         case (4) :{
            IDamage damage = new DamageMana() ;
            damage.Damaged(champion , much);
            System.out.println("hi from case 4 ");
            break;}
         default:
            throw new IllegalStateException("Unexpected value: " + id);
      }
      }

}
