package cl.uchile.dcc.finalreality.model.magicSpell;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.*;

public class Fire extends AbstractSpell {

  /**
   * Creates the Fire spell with the necesary effects.
   */
  public Fire() {
    super(15);
    Effect[] arr = {new ReduceHpWithMdEffect(), new Random20ToBurned()};
    this.spell = new CompositeEffect(arr);
  }
}
