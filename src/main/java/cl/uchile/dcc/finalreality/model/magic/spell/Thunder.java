package cl.uchile.dcc.finalreality.model.magic.spell;

import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.CompositeEffect;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.Effect;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.ParalyzeEffect;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.RandomComposite;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.ReduceHpWithMdEffect;
import java.util.Objects;

/**
 * This class represent the Thunder Spell. This spell hits the target with magicDamage
 * and have a 30% chance to paralyze it.
 */
public class Thunder extends AbstractSpell {

  /**
   * Creates the Thunder spell with the necesary effects.
   */
  public Thunder() {
    super(15);
    Effect[] randomArr = {new ParalyzeEffect()};
    Effect randomEffect = new RandomComposite(randomArr, 0.3);
    Effect[] arr = {new ReduceHpWithMdEffect(), randomEffect};
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
