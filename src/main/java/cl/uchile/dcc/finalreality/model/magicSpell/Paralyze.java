package cl.uchile.dcc.finalreality.model.magicSpell;

import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.CompositeEffect;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.Effect;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.NullEffect;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.ParalyzeEffect;
import java.util.Objects;

public class Paralyze extends AbstractSpell {

  /**
   * Creates the Paralyze spell with the necesary effects.
   */
  public Paralyze() {
    super(25);
    Effect[] arr = {new ParalyzeEffect()};
    this.spell = new CompositeEffect(arr);
  }

  @Override
  public int hashCode() {
    return Objects.hash(Paralyze.class);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final Paralyze that)) {
      return false;
    }
    return hashCode() == that.hashCode();
  }
}
