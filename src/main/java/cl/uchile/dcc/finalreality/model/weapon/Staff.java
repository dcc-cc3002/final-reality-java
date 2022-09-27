package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;

/**
 * Staff is a {@link Weapon} more specifically a {@link MagicWeapon} than can be
 * equipped by some PlayerCharacters.
 */
public class Staff extends AbstractMagicWeapon {

  public Staff(String name, int weight, int damage, int magicDamage) {
    super(name, weight, damage, magicDamage);
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
    if (!(o instanceof final Staff that)) {
      return false;
    }
    return this.hashCode() == that.hashCode()
        && this.getName().equals(that.getName())
        && this.getWeight() == that.getWeight()
        && this.getDamage() == that.getDamage()
        && this.getMagicDamage() == that.getMagicDamage();
  }

  @Override
  public String toString() {
    return "Staff{name=%s, weight=%d, damage='%d', magicDamage='%d'}"
           .formatted(this.getName(), this.getWeight(), this.getDamage(), this.getMagicDamage());
  }
}
