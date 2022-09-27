package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;

public class Staff extends AbstractMagicWeapon{

  public Staff(String name, int weight, int damage, int magic_damage) {
    super(name, weight, damage, magic_damage);
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
        && this.getMagic_damage() == that.getMagic_damage();
  }
  @Override
  public String toString() {
    return "Staff{name=%s, weight=%d, damage='%d', magic_damage='%d'}".formatted(this.getName(), this.getWeight(), this.getDamage(), this.getMagic_damage());
  }
}
