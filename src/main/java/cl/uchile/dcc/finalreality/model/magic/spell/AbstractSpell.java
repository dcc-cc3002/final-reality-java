package cl.uchile.dcc.finalreality.model.magic.spell;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.Effect;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.NullEffect;

/**
 * This Class represents a Spell of the game that can be equipped and used by Mages.
 */
public class AbstractSpell implements Spell {

  protected Effect spell = new NullEffect();
  private final int cost;

  /**
   * Creates a new Spell that haves an Effect and a cost.
   *
   * @param cost
   *     The cost in Mp of the Spell
   */

  protected AbstractSpell(int cost) {
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
