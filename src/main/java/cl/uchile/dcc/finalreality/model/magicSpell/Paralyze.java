package cl.uchile.dcc.finalreality.model.magicSpell;


import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.CompositeEffect;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.Effect;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.ParalyzeEffect;

public class Paralyze implements Spell{
  private final Effect spell;

  /**
   * Creates the Paralyze spell with the necesary effects.
   */
  public Paralyze() {
    Effect[] arr = {new ParalyzeEffect()};
    this.spell = new CompositeEffect(arr);
  }

  @Override
  public Effect getSpell() {
    return spell;
  }
}
