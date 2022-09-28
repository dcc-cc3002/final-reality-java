package cl.uchile.dcc.finalreality.model.weapon;

/**
 * This is a class that contains the information off an Item in the game.
 * Every item must have a name and a weight.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Arturo Kullmer~
 */
public abstract class AbstractItem implements Item {
  private final String name;
  private final int weight;
  /**
   * Constructor that creates a new Item.
   * It is protected because it will only be used by his subclasses.
   *
   * @param name
   *     the item's name
   * @param weight
   *     the item's weight
   */

  protected AbstractItem(String name, int weight) {
    this.name = name;
    this.weight = weight;
  }

  public String getName() {
    return name;
  }

  public int getWeight() {
    return weight;
  }
}
