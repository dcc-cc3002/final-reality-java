package cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;
import cl.uchile.dcc.finalreality.model.weapon.MagicWeapon;

public class ReduceHpWithMdEffect implements Effect {

  @Override
  public void apply(MageCharacter self, GameCharacter target) throws InvalidStatValueException {
    int damage = ((MagicWeapon)self.getEquippedWeapon()).getMagicDamage();
    int defense = target.getDefense();
    if (defense < damage) {
      target.setCurrentHp(target.getCurrentHp() - (damage - defense));
    }
  }
}
