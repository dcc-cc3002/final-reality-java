package cl.uchile.dcc.finalreality.model.magic.spell;

import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.BurnEffect;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.CompositeEffect;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.Effect;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.RandomComposite;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.ReduceHpWithMdEffect;
import java.util.Objects;

/**
 * This class represent the Fire Spell. This spell hits the target with magicDamage
 * and have a 20% chance to burn it.
 */
public class Fire extends AbstractSpell {

  /**
   * Creates the Fire spell with the necesary effects.
   */
  public Fire() {
    super(15);
    Effect[] randomArr = {new BurnEffect()};
    Effect randomEffect = new RandomComposite(randomArr, 0.2);
    Effect[] arr = {new ReduceHpWithMdEffect(), randomEffect};
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
