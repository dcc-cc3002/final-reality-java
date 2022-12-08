package cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;

public interface Effect {

  /**
   * @param self
   *     character using the spell with this effect.
   * @param target
   *     character that is going to get affected by this effect.
   */
  void apply(MageCharacter self, GameCharacter target) throws InvalidStatValueException;
}
