package cl.uchile.dcc.finalreality.model.magic.spell.composite.effects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;

/**
 * This interface represents an effect that can be used by a MageCharacter and affect
 * a GameCharacter.
 */
public interface Effect {

  /**
   * Applies the effect to the target.
   *
   * @param self
   *     character using the spell with this effect.
   * @param target
   *     character that is going to get affected by this effect.
   */
  void apply(MageCharacter self, GameCharacter target) throws InvalidStatValueException;
}
