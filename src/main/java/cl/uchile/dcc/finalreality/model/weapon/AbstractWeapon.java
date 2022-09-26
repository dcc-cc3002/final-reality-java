package cl.uchile.dcc.finalreality.model.weapon;

/**
 * This is an abstract class that contains the common information of all Weapon's in the game.
 */
public abstract class AbstractWeapon extends AbstractItem implements Weapon {
  private final int damage;

  /**
   * Create's a new Weapon
   *
   * @param name
   *     the item's name
   * @param weight
   *     the item's weight
   * @param damage
   *     the Weapon's damage
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
