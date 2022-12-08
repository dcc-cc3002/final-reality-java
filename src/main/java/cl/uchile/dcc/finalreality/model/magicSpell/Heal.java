package cl.uchile.dcc.finalreality.model.magicSpell;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.*;
import java.util.Objects;

public class Heal implements Spell {
  private final Effect spell;

  /**
   * Creates the Heal spell with the necesary effects.
   */
  public Heal() {
    Effect[] arr = {new Heal30Effect()};
    this.spell = new CompositeEffect(arr);
  }

  @Override
  public Effect getSpell() {
    return spell;
  }

  @Override
  public void apply(MageCharacter self, GameCharacter target) throws InvalidStatValueException {
    spell.apply(self, target);
  }

  @Override
  public String toString() {
    return "Heal{" +
        "spell=" + spell +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Heal heal = (Heal) o;
    return Objects.equals(spell, heal.spell);
  }

  @Override
  public int hashCode() {
    return Objects.hash(spell);
  }
}
