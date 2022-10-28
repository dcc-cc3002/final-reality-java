package cl.uchile.dcc.finalreality.model.weapon.interfaces;

import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

/**
 * This interfaces creates a contract with the {@link Weapon} that can
 * be equipped by an {@link Engineer}.
 */
public interface EquippableByEngineer {
  /**
   * Equips the current instanciated Weapon to the received PlayerCharacter.
   *
   * @param character
   *     the character that is equipping a Weapon
   */
  void equipToEngineer(@NotNull PlayerCharacter character);
}