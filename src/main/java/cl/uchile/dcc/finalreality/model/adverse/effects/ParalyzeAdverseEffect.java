package cl.uchile.dcc.finalreality.model.adverse.effects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.game.states.GameState;
import cl.uchile.dcc.finalreality.game.states.Idle;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/**
 * This class represents the Paralyze AdverseEffect.
 * This effect prevents a character of doing anything when it is his turn.
 * It only lasts 1 turn.
 */
public class ParalyzeAdverseEffect implements AdverseEffect {

  /**
   * Applies the effect of a Character being Paralyzed.
   */
  @Override
  public void applyEffect(@NotNull GameCharacter c, GameState s) throws InvalidStatValueException {
    c.setAdverseEffect(new NullAdverseEffect());
    c.waitTurn();
    s.changeState(new Idle());
  }

  @Override
  public int hashCode() {
    return Objects.hash(ParalyzeAdverseEffect.class);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final ParalyzeAdverseEffect that)) {
      return false;
    }
    return hashCode() == that.hashCode();
  }
}
