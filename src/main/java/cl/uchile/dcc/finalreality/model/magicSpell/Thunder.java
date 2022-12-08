package cl.uchile.dcc.finalreality.model.magicSpell;

import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.CompositeEffect;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.Effect;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.Random30ToParalyze;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.ReduceHpWithMdEffect;
import java.util.ArrayList;

public class Thunder implements Spell {
  private final Effect spell;

  public Thunder() {
    Effect[] arr = {new ReduceHpWithMdEffect(), new Random30ToParalyze()};
    this.spell = new CompositeEffect(arr);
  }
}
