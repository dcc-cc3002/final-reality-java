package cl.uchile.dcc.finalreality.model;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;

public interface Subscriber {
  /**
   * The subscriber reacts to a death of the publisher.
   */
  void updateDeath(GameCharacter c);

  /**
   * Reacts to a GameCharacter getting paralyzed
   */
  void addParalyzed(GameCharacter c);

  /**
   * Reacts to a GameCharacter getting Poisoned
   */
  void addPoison(GameCharacter c);

  /**
   * Reacts to a GameCharacter getting burned
   */
  void addBurned(GameCharacter c);
}
