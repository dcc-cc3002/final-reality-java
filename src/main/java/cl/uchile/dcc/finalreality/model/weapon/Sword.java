package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/**
 * Sword is a {@link Weapon} than can be equipped by some PlayerCharacters.
 */
public class Sword extends AbstractWeapon {

  /**
   * Creates a new Sword.
   *
   * @param name
   *     the weapon's name
   * @param weight
   *     the weapon's weight
   * @param damage
   *     the weapon's damage
   */
  public Sword(String name, int weight, int damage) {
    super(name, weight, damage);
  }

  @Override
  public Weapon equipToKnight(@NotNull Knight knight) {
    return this;
  }

  @Override
  public Weapon equipToThief(@NotNull Thief thief) {
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
    if (!(o instanceof final Sword that)) {
      return false;
    }
    return this.hashCode() == that.hashCode()
        && this.getName().equals(that.getName())
        && this.getWeight() == that.getWeight()
        && this.getDamage() == that.getDamage();
  }

  @Override
  public String toString() {
    return "Sword{name='%s', weight=%d, damage=%d}"
           .formatted(this.getName(), this.getWeight(), this.getDamage());
  }
}
