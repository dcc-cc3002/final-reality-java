package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.model.character.player.*;
import org.jetbrains.annotations.NotNull;

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

  /**
   * Returns the Weapon to be equipped by a BlackMage when it is possible.
   * In case that a BlackMage cannot equip a specific Weapon, it throws an Exception.
   * @param blackmage
   *     The BlackMage to be equipped with a Weapon.
   */
  Weapon equipToBlackMage(@NotNull BlackMage blackmage);

  /**
   * Returns the Weapon to be equipped by an Engineer when it is possible.
   * In case that an Engineer cannot equip a specific Weapon, it throws an Exception.
   * @param engineer
   *     The Engineer to be equipped with a Weapon.
   */
  Weapon equipToEngineer(@NotNull Engineer engineer);

  /**
   * Returns the Weapon to be equipped by a Knight when it is possible.
   * In case that a Knight cannot equip a specific Weapon, it throws an Exception.
   * @param knight
   *     The Knight to be equipped with a Weapon.
   */
  Weapon equipToKnight(@NotNull Knight knight);

  /**
   * Returns the Weapon to be equipped by a Thief when it is possible.
   * In case that a Thief cannot equip a specific Weapon, it throws an Exception.
   * @param thief
   *     The Thief to be equipped with a Weapon.
   */
  Weapon equipToThief(@NotNull Thief thief);

  /**
   * Returns the Weapon to be equipped by a WhiteMage when it is possible.
   * In case that a WhiteMage cannot equip a specific Weapon, it throws an Exception.
   * @param whitemage
   *     The WhiteMage to be equipped with a Weapon.
   */
  Weapon equipToWhiteMage(@NotNull WhiteMage whitemage);
}
