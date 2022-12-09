package cl.uchile.dcc.finalreality.model.magicSpell;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.*;
import java.util.Objects;

public class NullSpell extends AbstractSpell {

  /**
   * Creates the Null spell to represent when a spell is not equiped (Null-Obect Pattern).
   */
  public NullSpell() {
    super(0);
  }

  @Override
  public int hashCode() {
    return Objects.hash(NullSpell.class);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final NullSpell that)) {
      return false;
    }
    return hashCode() == that.hashCode();
  }
}
