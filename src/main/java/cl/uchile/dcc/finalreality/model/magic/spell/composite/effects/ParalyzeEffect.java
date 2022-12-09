package cl.uchile.dcc.finalreality.model.magic.spell.composite.effects;

import cl.uchile.dcc.finalreality.model.adverse.effects.ParalyzeAdverseEffect;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;
import java.util.Objects;

public class ParalyzeEffect implements Effect {
  @Override
  public void apply(MageCharacter self, GameCharacter target) {
    target.setAdverseEffect(new ParalyzeAdverseEffect());
  }

  @Override
  public int hashCode() {
    return Objects.hash(ParalyzeEffect.class);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final ParalyzeEffect that)) {
      return false;
    }
    return hashCode() == that.hashCode();
  }
}
