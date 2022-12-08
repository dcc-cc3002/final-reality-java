package cl.uchile.dcc.finalreality.model.magicSpell;

import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.Effect;

public interface Spell {

  /**
   * Returns the Effect of the current spell.
   */
  Effect getSpell();
}
