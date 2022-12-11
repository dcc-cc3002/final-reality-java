package cl.uchile.dcc.finalreality.game.states;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public class PlayerCharacterTurn extends AbstractGameState {
  protected PlayerCharacter playerCharacter;

  public PlayerCharacterTurn(@NotNull PlayerCharacter playerCharacter) {
    this.playerCharacter = playerCharacter;
  }

  @Override
  public void attack(GameCharacter target) throws InvalidStatValueException {
    changeState(new Idle());
    context.attack(playerCharacter, target);
  }

  @Override
  public void equipWeapon(Weapon w) throws InvalidWeaponTypeException {
    playerCharacter.equip(w);
  }

  /**
   * Getter for the current PlayerCharacter playing his turn.
   */
  public PlayerCharacter getPlayerCharacter() {
    return playerCharacter;
  }

  @Override
  public int hashCode() {
    return Objects.hash(PlayerCharacterTurn.class, this.playerCharacter);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final PlayerCharacterTurn that)) {
      return false;
    }
    return hashCode() == that.hashCode()
        && playerCharacter == that.getPlayerCharacter();
  }
}
