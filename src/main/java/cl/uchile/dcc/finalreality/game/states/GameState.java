package cl.uchile.dcc.finalreality.game.states;

import cl.uchile.dcc.finalreality.GameController;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidStateTransitionException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.magic.spell.Spell;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;

public interface GameState {

  /**
   * This method changes the state on the GameController to the recieved.
   *
   * @param s The state to be set.
   */
  void changeState(GameState s);

  /**
   * Setter for the context of the GameController (State-Pattern).
   */
  void setContext(GameController context);

  /**
   * Getter for the context of the GameController.
   */
  GameController getContext();

  /**
   * This method represents an attack in the game. In a specific Turn a GameCharacter can attack
   * to another GameCharacter. When attacking the turn ends.
   * This method can be used in the enemy turn or in the players turn.
   *
   * @param target The GameCharacter that recives the attack.
   */
  void attack(GameCharacter target) throws InvalidStateTransitionException, InvalidStatValueException;

  /**
   * This method represents equipping a Weapon in a turn, it only can be used in the Players turn.
   * Using this method does not end the current turn.
   *
   * @param w The Weapon that is going to get equipped.
   */
  void equipWeapon(Weapon w) throws InvalidStateTransitionException, InvalidWeaponTypeException;

  /**
   * This method represents using a Spell in a target. It is similar to an attack because it ends
   * the current turn. This method only can be used when it is the turn of a MageCharacter.
   * When the Mage does not have the sufficient Mp it does not end the turn.
   *
   * @param target The GameCharacter that recives the Effect of the Spell.
   */
  void useSpell(GameCharacter target) throws InvalidStateTransitionException;

  /**
   * Similar to equipping a Weapon, a MageCharacter can equip a Spell in his turn.
   * Equipping a Spell does not end the turn.
   *
   * @param s The Spell that is going to get equipped to the MageCharacter.
   */
  void equipSpell(Spell s) throws InvalidStateTransitionException;

  /**
   * This method decides who's turn is next and goes to that turn.
   */
  void nextTurn() throws InvalidStateTransitionException, InterruptedException, InvalidStatValueException;
}