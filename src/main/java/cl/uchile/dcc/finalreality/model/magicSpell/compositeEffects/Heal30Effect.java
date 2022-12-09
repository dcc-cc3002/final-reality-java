package cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.adverseEffects.ParalyzeAdverseEffect;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;
import java.util.Objects;

public class Heal30Effect implements Effect {

  @Override
  public void apply(MageCharacter self, GameCharacter target) throws InvalidStatValueException {
    int heal = (int)(target.getMaxHp()*0.3);
    try {
      target.setCurrentHp(target.getCurrentHp() + heal);
    }
    catch (InvalidStatValueException e) {
      target.setCurrentHp(target.getMaxHp());
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(Heal30Effect.class);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final Heal30Effect that)) {
      return false;
    }
    return hashCode() == that.hashCode();
  }
}
