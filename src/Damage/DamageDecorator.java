package Damage;
import Champion.*;
//Decorator Design Pattern for any thing ask me :P
public class DamageDecorator implements IDamage {
    public IDamage damage ;
    public DamageDecorator(IDamage damage){
       this.damage = damage ;
    }


    @Override
    public void Damaged(Champion champion, float much) {
        this.damage.Damaged(champion, much );
    }
}
