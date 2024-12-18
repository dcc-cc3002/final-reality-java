package cl.uchile.dcc.finalreality.model.magic.spell;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.Effect;

/**
 * This represents a Spell of the game. A MageCharacter can equip a Spell and use it to
 * affect any GameCharacters when it has the sufficient currentMp.
 */
public interface Spell {

  /**
   * Returns the Effect of the current spell.
   */
  Effect getSpell();

  /**
   * Apply the Effect of the spell to the target.
   *
   * @param self
   *     the Mage using the Spell.
   * @param target
   *     the GameCharacter that is being affected by the Spell.
   */
  void apply(MageCharacter self, GameCharacter target) throws InvalidStatValueException;

  /**
   * Getter for the cost of the Spell.
   */
  int getCost();
}
