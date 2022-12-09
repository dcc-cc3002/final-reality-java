package cl.uchile.dcc.finalreality.model.adverse.effects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * This represents an adverse effect of the game. A GameCharacter can be affected by a
 * adverse effect at the beginning of his turn.
 */
public interface AdverseEffect {
  /**
   * Applies the effect of that specific state.
   */
  void applyEffect(GameCharacter c) throws InvalidStatValueException;
}
