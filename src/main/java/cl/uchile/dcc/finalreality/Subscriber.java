package cl.uchile.dcc.finalreality;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;

/**
 * This represents a Subscriber of the Observer-Pattern. A subscriber watches over the object
 * that it subscribed to and reacts to changes in that object.
 */
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
