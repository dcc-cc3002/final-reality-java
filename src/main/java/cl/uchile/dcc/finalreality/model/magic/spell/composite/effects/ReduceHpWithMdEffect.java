package cl.uchile.dcc.finalreality.model.magic.spell.composite.effects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;
import java.util.Objects;

/**
 * This effect damages the target with the value of magicDamage of the Weapon equipped by
 * the caster. When a Weapon does not have magicDamage it does nothing.
 */
public class ReduceHpWithMdEffect implements Effect {

  @Override
  public void apply(MageCharacter self, GameCharacter target) throws InvalidStatValueException {
    try {
      int damage = self.getEquippedWeapon().getMagicDamage();
      int defense = target.getDefense();
      if (defense < damage) {
        target.setCurrentHp(target.getCurrentHp() - (damage - defense));
      }
    } catch (InvalidStatValueException e) {
      target.setCurrentHp(0);
      target.notifySubscribersDeath();
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(ReduceHpWithMdEffect.class);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final ReduceHpWithMdEffect that)) {
      return false;
    }
    return hashCode() == that.hashCode();
  }
}
