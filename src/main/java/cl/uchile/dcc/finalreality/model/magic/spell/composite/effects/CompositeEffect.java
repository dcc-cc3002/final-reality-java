package cl.uchile.dcc.finalreality.model.magic.spell.composite.effects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;
import java.util.Arrays;

/**
 * This represents the Composite class of the Composite pattern.
 * It contains a list of actual effects of the game.
 */
public class CompositeEffect implements Effect {
  private final Effect[] effects;

  /**
   * This class have a lists of effects.
   *
   * @param effects
   *     A list of effects that are used by a spell.
   */
  public CompositeEffect(Effect[] effects) {
    this.effects = effects;
  }

  @Override
  public void apply(MageCharacter self, GameCharacter target) throws InvalidStatValueException {
    for (Effect effect : effects) {
      effect.apply(self, target);
    }
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(effects);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final CompositeEffect that)) {
      return false;
    }
    return Arrays.equals(effects, that.effects);
  }
}
