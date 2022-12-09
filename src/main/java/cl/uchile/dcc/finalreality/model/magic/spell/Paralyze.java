package cl.uchile.dcc.finalreality.model.magic.spell;

import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.CompositeEffect;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.Effect;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.ParalyzeEffect;
import java.util.Objects;

/**
 * This class represents the Paralyze spell. It gives de Paralyze AdverseEffect to the target
 * and have a cost of 25 Mp.
 */
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
