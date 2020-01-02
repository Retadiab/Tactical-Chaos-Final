package Move;

import Champion.Champion;
import Damage.DamageCalculatorFactory;

public class ActiveGravesAbilityMove extends Move {

 public void PerformMove(Champion Target) {
     DamageCalculatorFactory.creatDamageCalculator(Target , 2 , 300);
     Target.CriticalDamage = 1 ;

 }

}
