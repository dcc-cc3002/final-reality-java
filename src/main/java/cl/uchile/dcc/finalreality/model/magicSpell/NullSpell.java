package cl.uchile.dcc.finalreality.model.magicSpell;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.*;

public class NullSpell implements Spell {
  private final Effect spell;

  /**
   * Creates the Null spell to represent when a spell is not equiped (Null-Obect Pattern).
   */
  public NullSpell() {
    Effect[] arr = {new NullEffect()};
    this.spell = new CompositeEffect(arr);
  }

  @Override
  public Effect getSpell() {
    return spell;
  }

  @Override
  public void apply(MageCharacter self, GameCharacter target) throws InvalidStatValueException {
    spell.apply(self, target);
  }
}
