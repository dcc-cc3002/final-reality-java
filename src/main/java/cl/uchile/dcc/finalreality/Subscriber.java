package cl.uchile.dcc.finalreality;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;

public interface Subscriber {
  /**
   * The subscriber reacts to a death of the publisher.
   */
  void updateDeath(GameCharacter c);
}
