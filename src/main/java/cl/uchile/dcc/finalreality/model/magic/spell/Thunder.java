package cl.uchile.dcc.finalreality.model.magic.spell;

import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.CompositeEffect;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.Effect;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.Random30ToParalyze;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.ReduceHpWithMdEffect;
import java.util.Objects;

public class Thunder extends AbstractSpell {

  /**
   * Creates the Thunder spell with the necesary effects.
   */
  public Thunder() {
    super(15);
    Effect[] arr = {new ReduceHpWithMdEffect(), new Random30ToParalyze()};
    this.spell = new CompositeEffect(arr);
  }

  @Override
  public int hashCode() {
    return Objects.hash(Thunder.class);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final Thunder that)) {
      return false;
    }
    return hashCode() == that.hashCode();
  }
}
