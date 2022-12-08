package cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;

public class Random30ToParalyze implements Effect {

  @Override
  public void apply(MageCharacter self, GameCharacter target) {
    if(Math.random() <= 0.3) {
      // target -> Paralyze
    }
  }
}
