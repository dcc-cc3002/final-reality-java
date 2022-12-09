package cl.uchile.dcc.finalreality.model.magic.spell;

import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.CompositeEffect;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.Effect;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.Random20ToBurned;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.ReduceHpWithMdEffect;
import java.util.Objects;

public class Fire extends AbstractSpell {

  /**
   * Creates the Fire spell with the necesary effects.
   */
  public Fire() {
    super(15);
    Effect[] arr = {new ReduceHpWithMdEffect(), new Random20ToBurned()};
    this.spell = new CompositeEffect(arr);
  }

  @Override
  public int hashCode() {
    return Objects.hash(Fire.class);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final Fire that)) {
      return false;
    }
    return hashCode() == that.hashCode();
  }
}
