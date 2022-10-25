package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import org.jetbrains.annotations.NotNull;

/**
 * This is an abstract class that contains the common information of all Weapon's in the game.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Arturo Kullmer~
 */
public abstract class AbstractWeapon implements Weapon {

  private final String name;
  private final int weight;
  private final int damage;

  /**
   * Create's a new Weapon.
   * Constructor is <b>protected</b> because it is only used by subclases,
   * and it will be not instanciated.
   *
   * @param name
   *     the weapon's name
   * @param weight
   *     the weapon's weight
   * @param damage
   *     the weapon's damage
   */
  protected AbstractWeapon(@NotNull String name, int weight, int damage)
      throws InvalidStatValueException {
    Require.statValueAtLeast(1, weight, "Weight");
    Require.statValueAtLeast(1, damage, "Damage");
    this.name = name;
    this.weight = weight;
    this.damage = damage;
  }

  public String getName() {
    return name;
  }

  public int getWeight() {
    return weight;
  }

  public int getDamage() {
    return damage;
  }
}
