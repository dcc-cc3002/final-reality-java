package cl.uchile.dcc.finalreality.model.magicSpell;


import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.CompositeEffect;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.Effect;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.ParalyzeEffect;

public class Paralyze {
  private final Effect spell;

  public Paralyze() {
    Effect[] arr = {new ParalyzeEffect()};
    this.spell = new CompositeEffect(arr);
  }
}
