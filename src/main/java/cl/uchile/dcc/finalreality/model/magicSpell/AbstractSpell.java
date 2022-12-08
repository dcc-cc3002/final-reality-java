package cl.uchile.dcc.finalreality.model.magicSpell;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.Effect;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.NullEffect;

public class AbstractSpell implements Spell {

  protected Effect spell = new NullEffect();
  private final int cost;

  public AbstractSpell(int cost) {
    this.cost = cost;
  }

  @Override
  public Effect getSpell() {
    return spell;
  }

  @Override
  public void apply(MageCharacter self, GameCharacter target) throws InvalidStatValueException {
    self.setCurrentMp(self.getCurrentMp() - cost);
    spell.apply(self, target);
  }

  @Override
  public int getCost() {
    return cost;
  }
}
