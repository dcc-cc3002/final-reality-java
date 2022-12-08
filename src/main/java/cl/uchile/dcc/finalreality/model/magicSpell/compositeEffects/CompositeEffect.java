package cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;

public class CompositeEffect implements Effect {
  private final Effect[] effects;

  /**
   *
   * @param effects
   *     A list of effects that are used by a spell.
   */
  public CompositeEffect(Effect[] effects) {
    this.effects = effects;
  }

  @Override
  public void apply(MageCharacter self, GameCharacter target) throws InvalidStatValueException {
    for(Effect effect : effects) {
      effect.apply(self, target);
    }
  }
}
