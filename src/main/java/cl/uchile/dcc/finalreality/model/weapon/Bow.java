package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;

public class Bow extends AbstractWeapon{

  public Bow(String name, int weight, int damage) {
    super(name, weight, damage);
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
    if (!(o instanceof final Bow that)) {
      return false;
    }
    return this.hashCode() == that.hashCode()
        && this.getName().equals(that.getName())
        && this.getWeight() == that.getWeight()
        && this.getDamage() == that.getDamage();
  }
  @Override
  public String toString() {
    return "Bow{name=%s, weight=%d, damage='%d'}".formatted(this.getName(), this.getWeight(), this.getDamage());
  }
}
