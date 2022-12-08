package cl.uchile.dcc.finalreality.model.magicSpell;


import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.CompositeEffect;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.Effect;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.PoisonEffect;

public class Poison implements Spell {
  private final Effect spell;

  /**
   * Creates the Poison spell with the necesary effects.
   */
  public Poison() {
    Effect[] arr = {new PoisonEffect()};
    this.spell = new CompositeEffect(arr);
  }

  public Effect getSpell() {
    return spell;
  }
}
