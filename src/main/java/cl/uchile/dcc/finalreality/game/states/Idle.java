package cl.uchile.dcc.finalreality.game.states;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidStateTransitionException;
import java.util.Objects;

/**
 * This class represents a neutral state between one turn and another.
 * The Idle state calculates which characters play next with the nextTurn method.
 */
public class Idle extends AbstractGameState {

  @Override
  public void nextTurn()
      throws InterruptedException, InvalidStatValueException, InvalidStateTransitionException {
    while (context.getTurnsQueue().isEmpty()) {
      Thread.sleep(100);
    }
    Objects.requireNonNull(context.getTurnsQueue().poll()).beginTurn(this);
  }

  @Override
  public int hashCode() {
    return Objects.hash(Idle.class);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final Idle that)) {
      return false;
    }
    return hashCode() == that.hashCode();
  }
}
