package cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;

public class NullEffect implements Effect {

  @Override
  public void apply(MageCharacter self, GameCharacter target) {
    // Do nothing, null-object pattern.
  }
}
