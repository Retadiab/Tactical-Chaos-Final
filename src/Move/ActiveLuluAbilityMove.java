package Move;

import Champion.Champion;

public class ActiveLuluAbilityMove extends Move {


    public void PerformMove(Champion Same){
        Same.health = Same.health + 150 ;
    }
}
