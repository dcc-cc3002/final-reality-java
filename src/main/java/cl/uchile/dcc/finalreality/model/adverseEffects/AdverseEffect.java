package cl.uchile.dcc.finalreality.model.adverseEffects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

public interface AdverseEffect {
  /**
   * Applies the effect of that specific state.
   */
  void applyEffect(GameCharacter c) throws InvalidStatValueException;
}
