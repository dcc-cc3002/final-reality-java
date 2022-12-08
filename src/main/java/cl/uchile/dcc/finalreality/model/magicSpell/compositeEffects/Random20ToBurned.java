package cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects;

import cl.uchile.dcc.finalreality.model.Subscriber;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;
import java.util.ArrayList;

public class Random20ToBurned implements Effect {

  @Override
  public void apply(MageCharacter self, GameCharacter target) {
    if(Math.random() <= 0.2) {
      ArrayList<Subscriber> subs = target.getSubscribers();
      for(Subscriber s : subs){
        s.addBurned(target);
      }
    }
  }
}
