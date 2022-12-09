package cl.uchile.dcc.finalreality.model.magic.spell.composite.effects;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;
import java.util.Objects;

public class NullEffect implements Effect {

  @Override
  public void apply(MageCharacter self, GameCharacter target) {
    // Do nothing, null-object pattern.
  }

  @Override
  public int hashCode() {
    return Objects.hash(NullEffect.class);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final NullEffect that)) {
      return false;
    }
    return hashCode() == that.hashCode();
  }
}
