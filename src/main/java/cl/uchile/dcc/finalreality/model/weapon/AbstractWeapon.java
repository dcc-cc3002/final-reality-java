package cl.uchile.dcc.finalreality.model.weapon;

/**
 * This is an abstract class that contains the common information of all Weapon's in the game.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Arturo Kullmer~
 */
public abstract class AbstractWeapon extends AbstractItem implements Weapon {
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
  protected AbstractWeapon(String name, int weight, int damage) {
    super(name, weight);
    this.damage = damage;
  }

  @Override
  public int getDamage() {
    return damage;
  }
}
