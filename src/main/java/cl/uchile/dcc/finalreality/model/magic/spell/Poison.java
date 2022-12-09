package cl.uchile.dcc.finalreality.model.magic.spell;

import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.CompositeEffect;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.Effect;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.PoisonEffect;
import java.util.Objects;

/**
 * This Spell gives the target the Poison AdverseEffect. It costs 40 Mp.
 */
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
