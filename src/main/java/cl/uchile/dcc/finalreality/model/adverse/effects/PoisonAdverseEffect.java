package cl.uchile.dcc.finalreality.model.adverse.effects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.game.states.GameState;
import cl.uchile.dcc.finalreality.game.states.Idle;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.util.Objects;

/**
 * This AdverseEffect represents Poison. It damages the poisoned GameCharacter at the beginning
 * of every single one of his turns.
 */
public class PoisonAdverseEffect implements AdverseEffect {

  private int poisonDamage;

  /**
   * Creates a Poison effect with the specific damage by poison.
   *
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
  public void applyEffect(GameCharacter c, GameState s) throws InvalidStatValueException {
    if (c.getCurrentHp() - poisonDamage <= 0) {
      c.setCurrentHp(0);
      c.notifySubscribersDeath();
      s.changeState(new Idle());
    } else {
      c.setCurrentHp(c.getCurrentHp() - poisonDamage);
    }
  }

  /**
   * Getter for the Poison damage.
   */
  public int getPoisonDamage() {
    return poisonDamage;
  }

  @Override
  public int hashCode() {
    return Objects.hash(PoisonAdverseEffect.class, this.poisonDamage);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final PoisonAdverseEffect that)) {
      return false;
    }
    return hashCode() == that.hashCode()
        && poisonDamage == that.getPoisonDamage();
  }
}
