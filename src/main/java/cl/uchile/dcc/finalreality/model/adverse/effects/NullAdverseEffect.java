package cl.uchile.dcc.finalreality.model.adverse.effects;

import cl.uchile.dcc.finalreality.game.states.GameState;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.util.Objects;

/**
 * We are using a Null-Object Pattern to represent when a character does not have an
 * Adverse effect. This Adverseeffect does nothing.
 */
public class NullAdverseEffect implements AdverseEffect {

  @Override
  public void applyEffect(GameCharacter c, GameState s) {
    // Do Nothing, Null-Object Pattern
  }

  @Override
  public int hashCode() {
    return Objects.hash(NullAdverseEffect.class);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final NullAdverseEffect that)) {
      return false;
    }
    return hashCode() == that.hashCode();
  }
}
