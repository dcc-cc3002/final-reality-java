package cl.uchile.dcc.finalreality.model.adverseEffects;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;

public class NullAdverseEffect implements AdverseEffect {

  /**
   * We are using a Null-Object Pattern to represent when a character does not have an effect.
   */
  @Override
  public void applyEffect(GameCharacter c) {
    // Do Nothing, Null-Object Pattern
  }
}
