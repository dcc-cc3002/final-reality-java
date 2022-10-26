package cl.uchile.dcc.finalreality.model.weapon;

/** A class that holds the information of a {@link Weapon} that have magic Damage such as Staff's.
 * In this case the only weapon with this property is the Staff, the purpose of this
 * abstract class is to make the code extensible to future implementations.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Arturo Kullmer~
 */
public abstract class AbstractMagicWeapon extends AbstractWeapon implements MagicWeapon {
  private final int magicDamage;

  /**
   * Create's a new MagicWeapon.
   * Constructor is <b>protected</b> because it is only used by subclases,
   * and it will be not instanciated.
   *
   * @param name
   *     the magic weapon's name
   * @param weight
   *     the magic weapon's weight
   * @param damage
   *     the magic weapon's damage (the normal damage, not the magic damage)
   * @param magicDamage
   *     the magic weapon's magic damage
   */
  protected AbstractMagicWeapon(String name, int weight, int damage, int magicDamage) {
    super(name, weight, damage);
    this.magicDamage = magicDamage;
  }

  /**
   * Returns the magic_damage of this Weapon.
   */
  public int getMagicDamage() {
    return magicDamage;
  }
}
