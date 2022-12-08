package cl.uchile.dcc.finalreality.model.magicSpell;


import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.CompositeEffect;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.Effect;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.PoisonEffect;

public class Poison implements Spell {
  private final Effect spell;

  /**
   * Creates the Poison spell with the necesary effects.
   */
  public Poison() {
    Effect[] arr = {new PoisonEffect()};
    this.spell = new CompositeEffect(arr);
  }

  public Effect getSpell() {
    return spell;
  }

  @Override
  public void apply(MageCharacter self, GameCharacter target) throws InvalidStatValueException {
    spell.apply(self, target);
  }
}
