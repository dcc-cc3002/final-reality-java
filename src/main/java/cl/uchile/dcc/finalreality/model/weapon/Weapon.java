package cl.uchile.dcc.finalreality.model.weapon;

/**
 * This represents a Weapon of the game.
 * A Weapon can be equipped only by a UsableCharacter.
 */
public interface Weapon {
  /**
   * Returns the Weapon's damage.
   */
  int getDamage();
}
