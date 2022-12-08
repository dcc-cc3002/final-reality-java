package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import org.jetbrains.annotations.NotNull;

/**
 * This is an abstract class that contains the common information of all Weapon's in the game.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Arturo Kullmer~
 */
public abstract class AbstractWeapon implements Weapon {

  private final String name;
  private final int weight;
  private final int damage;

  /**
   * Create's a new Weapon.
   * Constructor is <b>protected</b> because it is only used by subclases,
   * and it will be not instanciated.
   *
   * @param name
   *     the weapon's name
   * @param weight
   *     the weapon's weight
   * @param damage
   *     the weapon's damage
   */
  protected AbstractWeapon(@NotNull String name, int weight, int damage) {
    this.name = name;
    this.weight = weight;
    this.damage = damage;
  }

  public String getName() {
    return name;
  }

  public int getWeight() {
    return weight;
  }

  public int getDamage() {
    return damage;
  }

  public int getMagicDamage() {
    return 0;
  }

  public Weapon equipToBlackMage(@NotNull BlackMage blackmage) throws InvalidWeaponTypeException {
    throw new InvalidWeaponTypeException("A BlackMage can't equip this Weapon");
  }

  public Weapon equipToEngineer(@NotNull Engineer engineer) throws InvalidWeaponTypeException {
    throw new InvalidWeaponTypeException("An Engineer can't equip this Weapon");
  }

  public Weapon equipToKnight(@NotNull Knight knight) throws InvalidWeaponTypeException {
    throw new InvalidWeaponTypeException("A Knight can't equip this Weapon");
  }

  public Weapon equipToThief(@NotNull Thief thief) throws InvalidWeaponTypeException {
    throw new InvalidWeaponTypeException("A Thief can't equip this Weapon");
  }

  public Weapon equipToWhiteMage(@NotNull WhiteMage whiteMage) throws InvalidWeaponTypeException {
    throw new InvalidWeaponTypeException("A WhiteMage can't equip this Weapon");
  }
}
