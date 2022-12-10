package cl.uchile.dcc.finalreality.game.states;

import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;

public class MageCharacterTurn extends AbstractGameState {
  private MageCharacter mageCharacter;

  public MageCharacterTurn(MageCharacter mageCharacter) {
    this.mageCharacter = mageCharacter;
  }
}
