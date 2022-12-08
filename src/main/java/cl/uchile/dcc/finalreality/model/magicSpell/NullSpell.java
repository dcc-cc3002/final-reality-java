package cl.uchile.dcc.finalreality.model.magicSpell;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.*;

public class NullSpell extends AbstractSpell {

  /**
   * Creates the Null spell to represent when a spell is not equiped (Null-Obect Pattern).
   */
  public NullSpell() {
    super(0);
  }
}
