package cl.uchile.dcc.finalreality.model.weapon;

/**
 * This represents a MagicWeapon of the game. A MagicWeapon is a Weapon that also have MagicDamage.
 */
public interface MagicWeapon extends Weapon {

  /**
   * returns the MagicWeapon's magic_damage.
   */
  @Override
  int getMagicDamage();
}
