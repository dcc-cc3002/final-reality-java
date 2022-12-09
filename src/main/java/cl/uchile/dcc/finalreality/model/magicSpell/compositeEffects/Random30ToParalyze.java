package cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects;

import cl.uchile.dcc.finalreality.model.adverseEffects.ParalyzeAdverseEffect;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;
import java.util.Random;

public class Random30ToParalyze implements Effect {
  private Random random;

  public Random30ToParalyze() {
    this.random = new Random();
  }

  public void setRandom(Random random) {
    this.random = random;
  }

  public Random getRandom() {
    return random;
  }

  @Override
  public void apply(MageCharacter self, GameCharacter target) {
    if(random.nextDouble() <= 0.3) {
      target.setAdverseEffect(new ParalyzeAdverseEffect());
    }
  }
}
