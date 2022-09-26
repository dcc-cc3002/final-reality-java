package cl.uchile.dcc.finalreality.model.weapon;

/**
 * This is a class that contains the information off an Item in the game.
 * Every item must have a name, a type and a weight.
 */
public abstract class AbstractItem implements Item {
  private final String name;
  private final String type;
  private final int weight;
  /**
   * Constructor that creates a new Item.
   * It is protected because it will only be used by his subclasses.
   *
   * @param name
   *     the item's name
   * @param type
   *     the item's type
   * @param weight
   *     the item's weight
   */

  protected AbstractItem(String name, String type, int weight) {
    this.name = name;
    this.type = type;
    this.weight = weight;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getType() {
    return type;
  }

  @Override
  public int getWeight() {
    return weight;
  }
}
