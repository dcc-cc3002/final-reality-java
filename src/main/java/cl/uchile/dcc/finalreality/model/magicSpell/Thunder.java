package cl.uchile.dcc.finalreality.model.magicSpell;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.*;
import java.util.Random;

public class Thunder extends AbstractSpell {

  /**
   * Creates the Thunder spell with the necesary effects.
   */
  public Thunder() {
    super(15);
    Effect[] arr = {new ReduceHpWithMdEffect(), new Random30ToParalyze()};
    this.spell = new CompositeEffect(arr);
  }
}
