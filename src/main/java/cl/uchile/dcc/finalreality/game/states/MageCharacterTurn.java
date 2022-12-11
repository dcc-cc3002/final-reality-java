package cl.uchile.dcc.finalreality.game.states;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;
import cl.uchile.dcc.finalreality.model.magic.spell.Spell;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public class MageCharacterTurn extends PlayerCharacterTurn {

  private MageCharacter mageCharacter;

  public MageCharacterTurn(@NotNull MageCharacter mageCharacter) {
    super(mageCharacter);
    this.mageCharacter = mageCharacter;
  }

  @Override
  public void useSpell(GameCharacter target) {
    changeState(new Idle());
    context.useMagic(mageCharacter, target);
  }

  @Override
  public void equipSpell(Spell s) {
    mageCharacter.equipSpell(s);
  }

  @Override
  public int hashCode() {
    return Objects.hash(MageCharacterTurn.class, this.playerCharacter);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final MageCharacterTurn that)) {
      return false;
    }
    return hashCode() == that.hashCode()
        && playerCharacter == that.getPlayerCharacter();
  }


}
