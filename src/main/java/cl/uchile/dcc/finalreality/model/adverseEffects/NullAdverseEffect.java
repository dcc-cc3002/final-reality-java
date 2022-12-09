package cl.uchile.dcc.finalreality.model.adverseEffects;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import java.util.Objects;

public class NullAdverseEffect implements AdverseEffect {

  /**
   * We are using a Null-Object Pattern to represent when a character does not have an effect.
   */
  @Override
  public void applyEffect(GameCharacter c) {
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
