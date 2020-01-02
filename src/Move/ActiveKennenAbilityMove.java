package Move;

import Champion.Champion;
import Damage.DamageCalculatorFactory;

public class ActiveKennenAbilityMove extends Move {
    public void PerformMove(Champion Attacker  , Champion Target ){
        DamageCalculatorFactory.creatDamageCalculator(Target , 2 , Attacker.getBasicAttack() * (float)3.5);

    }
}
