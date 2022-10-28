package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;

/**
 * This represents a mage character of the game. A MageCharacter have spells and method's that
 * common characters do not have.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Arturo Kullmer~
 */
public interface MageCharacter extends PlayerCharacter {

  /**
   * Returns the maximum value of MP.
   */
  int getMaxMp();

  /**
   * Sets the current MP of the character to {@code newMp}.
   */
  void setCurrentMp(int newMp) throws InvalidStatValueException;

  /**
   * Returns the current MP of the character.
   */
  int getCurrentMp();
}
