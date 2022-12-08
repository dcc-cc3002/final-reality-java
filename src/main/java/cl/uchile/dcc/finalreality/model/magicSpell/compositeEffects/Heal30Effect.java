package cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;

public class Heal30Effect implements Effect {

  @Override
  public void apply(MageCharacter self, GameCharacter target) throws InvalidStatValueException {
    int heal = (int)(target.getMaxHp()*0.3);
    try {
      target.setCurrentHp(target.getCurrentHp() + heal);
    }
    catch (InvalidStatValueException e) {
      target.setCurrentHp(target.getMaxHp());
    }
  }
}
