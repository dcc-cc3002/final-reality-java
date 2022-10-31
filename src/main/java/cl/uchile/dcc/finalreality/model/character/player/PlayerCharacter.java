package cl.uchile.dcc.finalreality.model.character.player;

/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;

/**
 * A {@link GameCharacter} that can equip a weapon.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Arturo Kullmer~
 */
public interface PlayerCharacter extends GameCharacter {
  /**
   * Equips the received Weapon to the PlayerCharacter.
   */
  void equip(Weapon weapon);

  /**
   * Return this character's equipped weapon.
   */
  Weapon getEquippedWeapon();

  /**
   * Return the character's equipped weapon weight.
   */
  int getWeight() throws InvalidStatValueException;
}
