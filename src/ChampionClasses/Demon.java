package ChampionClasses;

import Champion.Champion;
import Damage.DamageCalculatorFactory;

public class Demon {


    public Champion ActiveAbilityFromClasses( Champion c , int numberOfChampions,Champion Target){
            if(numberOfChampions ==2 || numberOfChampions==3){

                DamageCalculatorFactory.creatDamageCalculator(Target,4, 40 );

                //just edit the attributes in champion
            }



            else if (numberOfChampions == 4){
                DamageCalculatorFactory.creatDamageCalculator(Target,4, 40 );

            }

            return c;
    }


}
