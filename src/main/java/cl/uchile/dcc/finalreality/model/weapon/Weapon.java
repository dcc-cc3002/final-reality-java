package cl.uchile.dcc.finalreality.model.weapon;

/**
 * This represents a Weapon of the game. A Weapon is contained in the player's inventory.
 * A Weapon can be equipped only by a PlayerCharacter.
 */
public interface Weapon {
  /**
   * Returns the Weapon's damage.
   */

  int getDamage();

  /**
   * Returns the Weapon's name.
   */
  String getName();

  /**
   * Returns the Weapon´s weight.
   */
  int getWeight();
}
