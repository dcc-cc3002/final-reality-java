package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.interfaces.EquippableByBlackMage;
import cl.uchile.dcc.finalreality.model.weapon.interfaces.EquippableByWhiteMage;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/**
 * Staff is a {@link Weapon} more specifically a {@link MagicWeapon} than can be
 * equipped by some PlayerCharacter's.
 */
public class Staff extends AbstractMagicWeapon implements
    EquippableByBlackMage, EquippableByWhiteMage {

  /**
   * Creates a new Staff.
   *
   * @param name
   *     the weapon's name
   * @param weight
   *     the weapon's weight
   * @param damage
   *     the weapon's damage
   * @param magicDamage
   *     the weapon's magic damage
   */
  public Staff(String name, int weight, int damage, int magicDamage) {
    super(name, weight, damage, magicDamage);
  }

  public void equipToWhiteMage(@NotNull PlayerCharacter character) {
    character.setEquippedWeapon(this);
  }

  public void equipToBlackMage(@NotNull PlayerCharacter character) {
    character.setEquippedWeapon(this);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getWeight(), getDamage());
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Staff that)) {
      return false;
    }
    return this.hashCode() == that.hashCode()
        && this.getName().equals(that.getName())
        && this.getWeight() == that.getWeight()
        && this.getDamage() == that.getDamage()
        && this.getMagicDamage() == that.getMagicDamage();
  }

  @Override
  public String toString() {
    return "Staff{name='%s', weight=%d, damage=%d, magicDamage=%d}"
           .formatted(this.getName(), this.getWeight(), this.getDamage(), this.getMagicDamage());
  }
}
