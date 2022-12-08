package cl.uchile.dcc.finalreality.model.adverseEffects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

public class PoisonAdverseEffect implements AdverseEffect {

  int poisonDamage;

  /**
   * Creates a Poison effect with the specific damage by poison.
   * @param poisonDamage
   *     The damage that is going to get applied to a GameCharacter when is poisoned.
   */
  public PoisonAdverseEffect(int poisonDamage) {
    this.poisonDamage = poisonDamage;
  }

  /**
   * Applies the effect of a Character being Poisoned.
   */
  @Override
  public void applyEffect(GameCharacter c) throws InvalidStatValueException {
    if(c.getCurrentHp() - poisonDamage <= 0) {
      c.setCurrentHp(0);
      c.notifySubscribersDeath();
    }
    else {
      c.setCurrentHp(c.getCurrentHp() - poisonDamage);
    }
  }
}
