package cl.uchile.dcc.finalreality.model.magicSpell;

import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.CompositeEffect;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.Effect;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.PoisonEffect;

public class Poison extends AbstractSpell {

  /**
   * Creates the Poison spell with the necesary effects.
   */
  public Poison() {
    super(40);
    Effect[] arr = {new PoisonEffect()};
    this.spell = new CompositeEffect(arr);
  }
}
