package Move;

import Champion.Champion;

public class ActiveGarenAbilityMove extends Move {

    public void PerformMove(Champion Target ) {
        Target.health = Target.health - (4) ;

    }
}
