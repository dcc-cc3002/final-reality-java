package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/**
 * Axe is a {@link Weapon} than can be equipped by some PlayerCharacters.
 */
public class Axe extends AbstractWeapon {

  /**
   * Creates a new Axe.
   *
   * @param name
   *     the weapon's name
   * @param weight
   *     the weapon's weight
   * @param damage
   *     the weapon's damage
   */
  public Axe(String name, int weight, int damage) {
    super(name, weight, damage);
  }

  @Override
  public Weapon equipToKnight(@NotNull Knight knight) {
    return this;
  }

  @Override
  public Weapon equipToEngineer(@NotNull Engineer engineer) {
    return this;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getWeight(), getDamage());
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Axe that)) {
      return false;
    }
    return this.hashCode() == that.hashCode()
        && this.getName().equals(that.getName())
        && this.getWeight() == that.getWeight()
        && this.getDamage() == that.getDamage();
  }

  @Override
  public String toString() {
    return "Axe{name='%s', weight=%d, damage=%d}"
           .formatted(this.getName(), this.getWeight(), this.getDamage());
  }

}
