package cl.uchile.dcc.finalreality.model.magic.spell;

import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.CompositeEffect;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.Effect;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.Heal30Effect;
import java.util.Objects;

/**
 * This class represents the Heal Spell. It heals the target a 30% of his maximum Hp.
 */
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
