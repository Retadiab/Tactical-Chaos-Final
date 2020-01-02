package Move;
import Arena.*;
import Champion.* ;
import Damage.*;
import Exceptions.IllegalSquare;
import Player.Player;

import java.util.ArrayList;
import java.util.Random;

public class BasicAttackMove  extends Move {
static Random r = new Random() ;





    public  ArrayList<Champion> attackAccepted(Champion Attacker , Arena arena, Player p){
        ArrayList<Champion> AttackableChampion = new ArrayList<Champion>();


            int stX = Attacker.x - (int)Attacker.AttackRange;
            if(stX<0) stX = 0;
            if(stX > 13) stX = 13;

            int  stY = Attacker.y - (int)Attacker.AttackRange;

                    if(stY<0) stY = 0;
                    if(stY >54) stY = 54;

        for (int i = stX; i < stX+(int)Attacker.AttackRange*2 ; i++) {
            for (int j = stY; j<  stY+(int)Attacker.AttackRange*2; j++) {

                if(arena.getSquare(i,j).getState() == SquaresState.Free){
                continue;

                }
                else if(arena.getSquare(i,j).getState() == SquaresState.Occupied) {




                    for(Champion c : arena.getSquare(i,j).getChampionsIn()) {
                        if (c.playerId == p.getPlayerIndex()) {
                        continue;

                        }


                        AttackableChampion.add(c);
                    }
                }

            }
        }


        return AttackableChampion ;
    }

    public boolean PerformMove(Champion Attacker , Champion Target ) {
        if(Target.getHealth() == 0 )
        {
            System.out.println("this Champion is dead ");



            return false;
        }

        else
        {
            int c = getRandom(4,1 ) ;
            if( c==1 || c==2 || c==3 ){
            DamageCalculatorFactory.creatDamageCalculator(Target , 2 , Attacker.getBasicAttack());
            Attacker.setMana(Attacker.getMana() + 1 );}
            else if (c==4){
                DamageCalculatorFactory.creatDamageCalculator(Target , 2 , Attacker.getBasicAttack() * Attacker.CriticalDamage);
                Attacker.setMana(Attacker.getMana() + 1 );}
            return true;

        }

    }








    public static int   getRandom(int h , int l)
    {
        return r.nextInt((h-l)+1)+l ;}
}
