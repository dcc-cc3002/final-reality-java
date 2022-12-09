package cl.uchile.dcc.finalreality.game.states;

import cl.uchile.dcc.finalreality.GameController;
import cl.uchile.dcc.finalreality.exceptions.InvalidStateTransitionException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.magic.spell.Spell;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;

public interface GameState {

  /**
   * Setter for the context of the GameController (State-Pattern).
   */
  void setContext(GameController context);

  /**
   * This method represents an attack in the game. In a specific Turn a GameCharacter can attack
   * to another GameCharacter. When attacking the turn ends.
   * This method can be used in the enemy turn or in the players turn.
   *
   * @param target
   *     The GameCharacter that recives the attack.
   */
  void attackTransition(GameCharacter target) throws InvalidStateTransitionException;

  /**
   * This method represents equipping a Weapon in a turn, it only can be used in the Players turn.
   * Using this method does not end the current turn.
   *
   * @param w
   *     The Weapon that is going to get equipped.
   */
  void equipWeaponTransition(Weapon w) throws InvalidStateTransitionException;

  /**
   * This method represents using a Spell in a target. It is similar to an attack because it ends
   * the current turn. This method only can be used when it is the turn of a MageCharacter.
   * When the Mage does not have the sufficient Mp it does not end the turn.
   *
   * @param target
   *     The GameCharacter that recives the Effect of the Spell.
   */
  void useSpellTransition(GameCharacter target) throws InvalidStateTransitionException;

  /**
   * Similar to equipping a Weapon, a MageCharacter can equip a Spell in his turn.
   * Equipping a Spell does not end the turn.
   *
   * @param s
   *     The Spell that is going to get equipped to the MageCharacter.
   */
  void equipSpellTransition(Spell s) throws InvalidStateTransitionException;
}
