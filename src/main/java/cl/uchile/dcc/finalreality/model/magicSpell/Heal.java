package cl.uchile.dcc.finalreality.model.magicSpell;

import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.*;
import java.util.Objects;

public class Heal extends AbstractSpell {

  /**
   * Creates the Heal spell with the necesary effects.
   */
  public Heal() {
    super(15);
    Effect[] arr = {new Heal30Effect()};
    this.spell = new CompositeEffect(arr);
  }

  @Override
  public int hashCode() {
    return Objects.hash(Heal.class);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final Heal that)) {
      return false;
    }
    return hashCode() == that.hashCode();
  }
}
