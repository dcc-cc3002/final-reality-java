package cl.uchile.dcc.finalreality.model.adverse.effects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

public interface AdverseEffect {
  /**
   * Applies the effect of that specific state.
   */
  void applyEffect(GameCharacter c) throws InvalidStatValueException;
}
