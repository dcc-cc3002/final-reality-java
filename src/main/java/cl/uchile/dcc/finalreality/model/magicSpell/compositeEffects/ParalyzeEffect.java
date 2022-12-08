package cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects;

import cl.uchile.dcc.finalreality.model.adverseEffects.ParalyzeAdverseEffect;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;

public class ParalyzeEffect implements Effect {
  @Override
  public void apply(MageCharacter self, GameCharacter target) {
      target.setAdverseEffect(new ParalyzeAdverseEffect());
  }
}
