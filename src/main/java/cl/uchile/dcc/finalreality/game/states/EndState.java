package cl.uchile.dcc.finalreality.game.states;

import java.util.Objects;

/**
 * This class represents the EndState of a battle. When this state is reached it can't call any
 * more methods. Reaching this state means that either the PlayerCharactersor
 * the enemies won the battle.
 */
public class EndState extends AbstractGameState {

  @Override
  public int hashCode() {
    return Objects.hash(EndState.class);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final EndState that)) {
      return false;
    }
    return hashCode() == that.hashCode();
  }
}
