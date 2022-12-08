package cl.uchile.dcc.finalreality.model.magicSpell;

import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.*;

public class Fire implements Spell {
  private final Effect spell;

  /**
   * Creates the Fire spell with the necesary effects.
   */
  public Fire() {
    Effect[] arr = {new ReduceHpWithMdEffect(), new Random20ToBurned()};
    this.spell = new CompositeEffect(arr);
  }

  @Override
  public Effect getSpell() {
    return spell;
  }
}
