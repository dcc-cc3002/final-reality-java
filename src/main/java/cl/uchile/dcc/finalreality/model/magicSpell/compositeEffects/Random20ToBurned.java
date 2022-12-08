package cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects;

import cl.uchile.dcc.finalreality.model.adverseEffects.BurnedAdverseEffect;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;

public class Random20ToBurned implements Effect {

  @Override
  public void apply(MageCharacter self, GameCharacter target) {
    if(Math.random() <= 0.2) {
      target.setAdverseEffect(new BurnedAdverseEffect(
          self.getEquippedWeapon().getMagicDamage()/2));
    }
  }
}
