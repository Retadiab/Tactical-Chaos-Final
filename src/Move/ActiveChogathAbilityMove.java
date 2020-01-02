package Move;

import Champion.Champion;
import Damage.DamageCalculatorFactory;

public class ActiveChogathAbilityMove extends Move{
    public void PerformMove( Champion Target ){
        DamageCalculatorFactory.creatDamageCalculator(Target,1, 150 );

    }
}
