package cl.uchile.dcc.finalreality.model.magicSpell;

import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.CompositeEffect;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.Effect;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.NullEffect;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.ParalyzeEffect;

public class Paralyze extends AbstractSpell {

  /**
   * Creates the Paralyze spell with the necesary effects.
   */
  public Paralyze() {
    super(25);
    Effect[] arr = {new ParalyzeEffect()};
    this.spell = new CompositeEffect(arr);
  }
}
