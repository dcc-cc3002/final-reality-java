package cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;

public class ReduceHpWithMdEffect implements Effect {

  @Override
  public void apply(MageCharacter self, GameCharacter target) throws InvalidStatValueException {
    try {
      int damage = self.getEquippedWeapon().getMagicDamage();
      int defense = target.getDefense();
      if (defense < damage) {
        target.setCurrentHp(target.getCurrentHp() - (damage - defense));
      }
    }
    catch (InvalidStatValueException e) {
      target.setCurrentHp(0);
      target.notifySubscribersDeath();
    }
  }
}
