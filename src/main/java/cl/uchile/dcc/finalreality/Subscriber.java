package cl.uchile.dcc.finalreality;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;

public interface Subscriber {

  /**
   * The subscriber reacts to the death of the recivied PlayerCharacter.
   */
  void updateDeathOfPlayerCharacter(GameCharacter c);

  /**
   * The subscriber reacts to the death of the recivied Enemy.
   */
  void updateDeathOfEnemy(GameCharacter c);
}
