package cl.uchile.dcc.finalreality.model.magic.spell.composite.effects;

import cl.uchile.dcc.finalreality.model.adverse.effects.BurnedAdverseEffect;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;
import java.util.Objects;

/**
 * This class represents an effect that burns the recived target.
 */
public class BurnEffect implements Effect {

  @Override
  public void apply(MageCharacter self, GameCharacter target) {
    target.setAdverseEffect(new BurnedAdverseEffect(
        self.getEquippedWeapon().getMagicDamage() / 2));
  }

  @Override
  public int hashCode() {
    return Objects.hash(BurnEffect.class);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final BurnEffect that)) {
      return false;
    }
    return hashCode() == that.hashCode();
  }
}
