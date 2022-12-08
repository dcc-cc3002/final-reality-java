package cl.uchile.dcc.finalreality.model.magicSpell;

import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.*;

public class Heal implements Spell {
  private final Effect spell;

  /**
   * Creates the Heal spell with the necesary effects.
   */
  public Heal() {
    Effect[] arr = {new Heal30Effect()};
    this.spell = new CompositeEffect(arr);
  }

  @Override
  public Effect getSpell() {
    return spell;
  }
}
