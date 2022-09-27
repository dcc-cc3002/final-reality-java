package cl.uchile.dcc.finalreality.model.weapon;


/** A class that holds the information of Weapons that have magic Damage such as Staff's.
 * In this case the only Weapon with this property is the Staff, the purpose of this
 * abstract class is to make the code extensible to future implementations.
 */
public abstract class AbstractMagicWeapon extends AbstractWeapon implements MagicWeapon {
  private final int magic_damage;

  /**
   * Create's a new MagicWeapon.
   *
   * @param name
   *     the MagicWeapon's name
   * @param weight
   *     the MagicWeapon's weight
   * @param damage
   *     the MagicWeapon's damage (the normal damage, not the magic damage)
   * @param magic_damage
   *     the MagicWeapon's magic damage
   */
  public AbstractMagicWeapon(String name, int weight, int damage, int magic_damage) {
    super(name, weight, damage);
    this.magic_damage = magic_damage;
  }

  /**
   * Returns the magic_damage of this Weapon.
   */
  public int getMagic_damage() {
    return magic_damage;
  }
}
