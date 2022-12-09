package cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects;

import cl.uchile.dcc.finalreality.model.adverseEffects.BurnedAdverseEffect;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;
import java.util.Random;

public class Random20ToBurned implements Effect {

  private Random random;

  public Random20ToBurned() {
    this.random = new Random();
  }

  /**
   * Returns the Random object of this class.
   */
  public Random getRandom() {
    return random;
  }

  /**
   * Sets the Random element to the recivied.
   */
  public void setRandom(Random random) {
    this.random = random;
  }

  @Override
  public void apply(MageCharacter self, GameCharacter target) {
    if(random.nextDouble() <= 0.2) {
      target.setAdverseEffect(new BurnedAdverseEffect(
          self.getEquippedWeapon().getMagicDamage()/2));
    }
  }
}
