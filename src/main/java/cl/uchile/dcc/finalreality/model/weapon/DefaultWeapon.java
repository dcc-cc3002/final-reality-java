package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;

/**
 * A class that holds all the information of a weapon.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Arturo Kullmer~
 */
public class DefaultWeapon {

  private final String name;
  private final int damage;
  private final int weight;
  private final WeaponType type;

  /**
   * Creates a weapon with a name, a base damage, speed, and it's type.
   */
  public DefaultWeapon(final String name, final int damage, final int weight,
                       final WeaponType type) {
    this.name = name;
    this.damage = damage;
    this.weight = weight;
    this.type = type;
  }

  private String getName() {
    return name;
  }

  private int getDamage() {
    return damage;
  }

  /**
   * Returns the weight of the weapon.
   */
  public int getWeight() {
    return weight;
  }

  private WeaponType getType() {
    return type;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final DefaultWeapon defaultWeapon)) {
      return false;
    }
    return hashCode() == defaultWeapon.hashCode()
        && damage == defaultWeapon.damage
        && weight == defaultWeapon.weight
        && name.equals(defaultWeapon.name)
        && type == defaultWeapon.type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(DefaultWeapon.class, name, damage, weight, type);
  }

  @Override
  public String toString() {
    return "Weapon{name='%s', damage=%d, weight=%d, type=%s}"
        .formatted(name, damage, weight, type);
  }

}