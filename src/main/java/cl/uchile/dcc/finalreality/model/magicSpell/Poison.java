package cl.uchile.dcc.finalreality.model.magicSpell;

import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.CompositeEffect;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.Effect;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.PoisonEffect;
import java.util.Objects;

public class Poison extends AbstractSpell {

  /**
   * Creates the Poison spell with the necesary effects.
   */
  public Poison() {
    super(40);
    Effect[] arr = {new PoisonEffect()};
    this.spell = new CompositeEffect(arr);
  }

  @Override
  public int hashCode() {
    return Objects.hash(Poison.class);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final Poison that)) {
      return false;
    }
    return hashCode() == that.hashCode();
  }
}
