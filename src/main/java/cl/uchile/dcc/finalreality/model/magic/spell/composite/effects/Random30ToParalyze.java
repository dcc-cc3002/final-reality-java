package cl.uchile.dcc.finalreality.model.magic.spell.composite.effects;

import cl.uchile.dcc.finalreality.model.adverse.effects.ParalyzeAdverseEffect;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;
import java.util.Objects;
import java.util.Random;

/**
 * This effect gives the target the Paralyze AdverseEffect with a 30% chance.
 */
public class Random30ToParalyze implements Effect {
  private Random random;

  public Random30ToParalyze() {
    this.random = new Random();
  }

  public void setRandom(Random random) {
    this.random = random;
  }

  public Random getRandom() {
    return random;
  }

  @Override
  public void apply(MageCharacter self, GameCharacter target) {
    if (random.nextDouble() <= 0.3) {
      target.setAdverseEffect(new ParalyzeAdverseEffect());
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(Random30ToParalyze.class);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final Random30ToParalyze that)) {
      return false;
    }
    return hashCode() == that.hashCode();
  }
}
