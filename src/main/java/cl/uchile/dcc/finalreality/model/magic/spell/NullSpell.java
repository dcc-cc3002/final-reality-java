package cl.uchile.dcc.finalreality.model.magic.spell;

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
