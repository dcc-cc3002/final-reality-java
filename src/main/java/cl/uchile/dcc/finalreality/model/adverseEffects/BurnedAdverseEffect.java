package cl.uchile.dcc.finalreality.model.adverseEffects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

public class BurnedAdverseEffect implements AdverseEffect {
  int burnedDamage;

  /**
   * Creates a Poison effect with the specific damage by burn.
   * @param burnDamage
   *     The damage that is going to get applied to a GameCharacter when is burned.
   */
  public BurnedAdverseEffect(int burnDamage) {
    this.burnedDamage = burnedDamage;
  }

  /**
   * Applies the effect of a Character being Burned.
   */
  @Override
  public void applyEffect(GameCharacter c) throws InvalidStatValueException {
    if(c.getCurrentHp() - burnedDamage <= 0) {
      c.setCurrentHp(0);
      c.notifySubscribersDeath();
    }
    else {
      c.setCurrentHp(c.getCurrentHp() - burnedDamage);
    }
  }
}
