package Damage;
import Champion.*;

public class Main1 {

    public static void main(String[] args) {
  // Champion champion = new Champion() ;
//        Champion champion1 = new Champion() ;
//        Champion champion2 = new Champion();
//        Champion champion3 = new Champion() ;
        Champion champion4 = new Champion() ;
        //champion4.setHealth((float) 40.0);
//        IDamage damage = new DamageAttack() ;
//        damage.Damaged(champion , (float) 30.0);
//       System.out.println(champion.getHealth());
//        IDamage damage1 = new DamageArmor(new DamageAttack()) ;
//        damage1.Damaged(champion1 , 50 );
//        System.out.println(champion1.getHealth());
//        IDamage damage2 = new DamageAbility(new DamageAttack());
//        damage2.Damaged(champion2,100);
//        System.out.println(champion2.getHealth());
//        IDamage damage3 = new DamageMana();
//        damage3.Damaged(champion3 ,50);
//        System.out.println(champion3.getMana());
for (int i=1 ; i < 5 ; i++) {
    champion4.setHealth(100);
    DamageCalculatorFactory.creatDamageCalculator(champion4, i, 10);
    System.out.println(champion4.getHealth());
    System.out.println(champion4.getMana());

}


    }
}
