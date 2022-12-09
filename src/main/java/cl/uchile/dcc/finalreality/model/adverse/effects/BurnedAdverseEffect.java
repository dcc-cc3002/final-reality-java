package cl.uchile.dcc.finalreality.model.adverse.effects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.util.Objects;

public class BurnedAdverseEffect implements AdverseEffect {
  int burnedDamage;

  /**
   * Creates a Poison effect with the specific damage by burn.
   *
   * @param burnDamage
   *     The damage that is going to get applied to a GameCharacter when is burned.
   */
  public BurnedAdverseEffect(int burnDamage) {
    this.burnedDamage = burnDamage;
  }

  /**
   * Applies the effect of a Character being Burned.
   */
  @Override
  public void applyEffect(GameCharacter c) throws InvalidStatValueException {
    if (c.getCurrentHp() - burnedDamage <= 0) {
      c.setCurrentHp(0);
      c.notifySubscribersDeath();
    } else {
      c.setCurrentHp(c.getCurrentHp() - burnedDamage);
    }
  }

  /**
   * Getter for the Burn damage.
   */
  public int getBurnedDamage() {
    return burnedDamage;
  }

  @Override
  public int hashCode() {
    return Objects.hash(BurnedAdverseEffect.class, this.burnedDamage);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final BurnedAdverseEffect that)) {
      return false;
    }
    return hashCode() == that.hashCode()
        && burnedDamage == that.getBurnedDamage();
  }
}
