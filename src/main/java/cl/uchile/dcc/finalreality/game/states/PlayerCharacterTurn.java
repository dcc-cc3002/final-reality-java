package cl.uchile.dcc.finalreality.game.states;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;

public class PlayerCharacterTurn extends AbstractGameState {
  private PlayerCharacter playerCharacter;

  public PlayerCharacterTurn(PlayerCharacter playerCharacter) {
    this.playerCharacter = playerCharacter;
  }

  @Override
  public void attack(GameCharacter target) {

  }

  @Override
  public void equipWeapon(Weapon w) {

  }
}
