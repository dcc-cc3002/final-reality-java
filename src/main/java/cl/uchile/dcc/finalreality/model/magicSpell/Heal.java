package cl.uchile.dcc.finalreality.model.magicSpell;

import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.*;

public class Heal extends AbstractSpell {

  /**
   * Creates the Heal spell with the necesary effects.
   */
  public Heal() {
    super(15);
    Effect[] arr = {new Heal30Effect()};
    this.spell = new CompositeEffect(arr);
  }
}
