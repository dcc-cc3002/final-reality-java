package cl.uchile.dcc.finalreality.model.weapon;

/**
 * This represents an Item of the game
 * We will consider an Item as something that can be contained in the player's inventory.
 */
public interface Item {
  /**
   * Returns the Item's name.
   */
  String getName();

  /**
   * Returns the Item´s weight.
   */
  int getWeight();
}
