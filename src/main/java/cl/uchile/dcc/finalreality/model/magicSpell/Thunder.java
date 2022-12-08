package cl.uchile.dcc.finalreality.model.magicSpell;

import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.CompositeEffect;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.Effect;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.Random30ToParalyze;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.ReduceHpWithMdEffect;

public class Thunder implements Spell {
  private final Effect spell;

  /**
   * Creates the Thunder spell with the necesary effects.
   */
  public Thunder() {
    Effect[] arr = {new ReduceHpWithMdEffect(), new Random30ToParalyze()};
    this.spell = new CompositeEffect(arr);
  }

  @Override
  public Effect getSpell() {
    return spell;
  }
}
