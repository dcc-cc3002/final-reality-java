package cl.uchile.dcc.finalreality.model.character.player;

/**
 * This represents a Mage character of the game. A Mage have spells and method's that common characters
 * do not have.
 */
public interface Mage {

  /**
   * Returns the Mage's maximum value of MP.
   */
  public int getMaxMp();

  /**
   * Sets the current MP of the character to {@code newMp}.
   */
  public void setCurrentMp(int newMP);

  /**
   * Returns the current MP of the character.
   */
  public int getCurrentMp();
}
