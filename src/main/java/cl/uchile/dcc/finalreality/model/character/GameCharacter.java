package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.Subscriber;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidStateTransitionException;
import cl.uchile.dcc.finalreality.game.states.GameState;
import cl.uchile.dcc.finalreality.model.adverse.effects.AdverseEffect;
import java.util.ArrayList;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Arturo Kullmer~
 */
public interface GameCharacter {

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  void waitTurn() throws InvalidStatValueException;

  /**
   * Returns this character's name.
   */
  String getName();

  /**
   * Returns this character's current HP.
   */
  int getCurrentHp();

  /**
   * Returns this character's max HP.
   */
  int getMaxHp();

  /**
   * Returns this character's defense.
   */
  int getDefense();

  /**
   * Sets this character's current HP to {@code newHp}.
   */
  void setCurrentHp(int hp) throws InvalidStatValueException;

  /**
   * Return the weight of the Character at that current moment.
   * Note that in the case of a {@code PlayerCharacter} his weight
   * is determined by his equipped weapon.
   */
  int getWeight() throws InvalidStatValueException;

  /**
   * Return the attack of the Character at that current moment.
   * Note that in the case of a {@code PlayerCharacter} his attack
   * is determined by his equipped weapon.
   */
  int getAttack() throws InvalidStatValueException;

  /**
   * Sets the AdverseEffect to the specified.
   */
  void setAdverseEffect(AdverseEffect ae);

  /**
   * Gets the current AdverseEffect of the GameCharacter.
   */
  AdverseEffect getAdverseEffect();

  /**
   * Add the recivied subscriber to the Suscriber list.
   */
  void subscribe(Subscriber s);

  /**
   * Notify all the subscriber about that the current class died.
   */
  void notifySubscribersDeath();

  /**
   * Getter for array with subscribers.
   */
  ArrayList<Subscriber> getSubscribers();

  /**
   * It begins the turn of the GameCharacter.
   * Begining a turn means that a GameCharacter now is allowed to do certain actions.
   *
   * @param s
   *     The state from where this method is called.
   */
  void beginTurn(GameState s)
      throws InvalidStatValueException, InvalidStateTransitionException, InterruptedException;
}
