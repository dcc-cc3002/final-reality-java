package cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects;

import cl.uchile.dcc.finalreality.model.adverseEffects.PoisonAdverseEffect;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;

public class PoisonEffect implements Effect {

  @Override
  public void apply(MageCharacter self, GameCharacter target) {
    target.setAdverseEffect(new PoisonAdverseEffect(
        self.getEquippedWeapon().getMagicDamage()/3));
  }
}
