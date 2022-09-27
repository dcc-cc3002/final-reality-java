package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * This represents a Weapon of the game, a Weapon is also an {@link Item} and
 * it must extend that interface.
 * A Weapon can be equipped only by a PlayerCharacter.
 */
public interface Weapon extends Item {
  /**
   * Returns the Weapon's damage.
   */
  int getDamage();
}
