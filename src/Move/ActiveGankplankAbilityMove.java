package Move;

import Champion.Champion;

public class ActiveGankplankAbilityMove extends Move {
    public void PerformMove(Champion champion) {
        champion.AttackDamage = champion.AttackDamage * 2 ;
        champion.VisionRange = champion.VisionRange * 2 ;
    }
}
