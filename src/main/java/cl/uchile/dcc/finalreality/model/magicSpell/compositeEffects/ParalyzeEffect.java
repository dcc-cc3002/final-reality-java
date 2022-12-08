package cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects;

import cl.uchile.dcc.finalreality.Subscriber;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;
import java.util.ArrayList;

public class ParalyzeEffect implements Effect {
  @Override
  public void apply(MageCharacter self, GameCharacter target) {
    ArrayList<Subscriber> subs = target.getSubscribers();
    for(Subscriber s : subs){
      s.addParalyzed(target);
    }
  }
}
