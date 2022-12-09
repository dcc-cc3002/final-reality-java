package cl.uchile.dcc.finalreality.model.magic.spell.composite.effects;

import cl.uchile.dcc.finalreality.model.adverse.effects.PoisonAdverseEffect;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;
import java.util.Objects;

/**
 * This effect gives the target the Poison AdverseEffect.
 */
public class PoisonEffect implements Effect {

  @Override
  public void apply(MageCharacter self, GameCharacter target) {
    target.setAdverseEffect(new PoisonAdverseEffect(
        self.getEquippedWeapon().getMagicDamage() / 3));
  }

  @Override
  public int hashCode() {
    return Objects.hash(PoisonEffect.class);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final PoisonEffect that)) {
      return false;
    }
    return hashCode() == that.hashCode();
  }
}
