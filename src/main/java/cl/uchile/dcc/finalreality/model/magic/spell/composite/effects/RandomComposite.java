package cl.uchile.dcc.finalreality.model.magic.spell.composite.effects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 * This class represents a composite component that contains effects that have a fixed random chance
 * of happening.
 */
public class RandomComposite extends CompositeEffect {
  private Random random;
  private final double probability;

  /**
   * This class have a lists of effects.
   *
   * @param randomEffects
   *     A list of effects that are used by a spell.
   * @param probabiity
   *     The probability of the effect getting applied.
   */
  public RandomComposite(Effect[] randomEffects, double probabiity) {
    super(randomEffects);
    this.probability = probabiity;
    this.random = new Random();
  }

  @Override
  public void apply(MageCharacter self, GameCharacter target) throws InvalidStatValueException {
    if (random.nextDouble() < probability) {
      super.apply(self, target);
    }
  }

  /**
   * Setter for the random value for testing.
   */
  public void setRandom(Random random) {
    this.random = random;
  }

  /**
   * Getter for the random value for testing.
   */
  public Random getRandom() {
    return random;
  }

  @Override
  public int hashCode() {
    return Objects.hash(RandomComposite.class, probability, Arrays.hashCode(effects));
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final RandomComposite that)) {
      return false;
    }
    return Arrays.equals(effects, that.effects)
        && probability == that.probability;
  }
}
