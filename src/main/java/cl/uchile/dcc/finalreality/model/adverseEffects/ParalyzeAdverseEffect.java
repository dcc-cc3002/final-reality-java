package cl.uchile.dcc.finalreality.model.adverseEffects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

public class ParalyzeAdverseEffect implements AdverseEffect {

  /**
   * Applies the effect of a Character being Paralyzed.
   */
  @Override
  public void applyEffect(GameCharacter c) throws InvalidStatValueException {
    c.setAdverseEffect(new NullAdverseEffect());
    c.waitTurn();
  }
}
