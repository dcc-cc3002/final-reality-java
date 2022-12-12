package cl.uchile.dcc.finalreality.game.states;

import java.util.Objects;

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
