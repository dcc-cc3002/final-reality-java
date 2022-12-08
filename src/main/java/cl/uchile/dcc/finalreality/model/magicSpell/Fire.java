package cl.uchile.dcc.finalreality.model.magicSpell;

import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.*;

public class Fire implements Spell {
  private final Effect spell;

  public Fire() {
    Effect[] arr = {new ReduceHpWithMdEffect(), new Random20ToBurned()};
    this.spell = new CompositeEffect(arr);
  }
}
