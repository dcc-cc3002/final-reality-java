package cl.uchile.dcc.finalreality.model.adverse.effects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public class ParalyzeAdverseEffect implements AdverseEffect {

  /**
   * Applies the effect of a Character being Paralyzed.
   */
  @Override
  public void applyEffect(@NotNull GameCharacter c) throws InvalidStatValueException {
    c.setAdverseEffect(new NullAdverseEffect());
    c.waitTurn();
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
