package cl.uchile.dcc.finalreality.game.states;

import cl.uchile.dcc.finalreality.GameController;
import cl.uchile.dcc.finalreality.exceptions.InvalidStateTransitionException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.magic.spell.Spell;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract Class that throws an exception by default when a transition is not expected in
 * a subclass.
 */
public class AbstractGameState implements GameState {
  private GameController context;

  @Override
  public void setContext(GameController context) {
    this.context = context;
  }

  @Override
  public void attackTransition(GameCharacter target) throws InvalidStateTransitionException {
    throw new InvalidStateTransitionException("Cannot attack in the current GameState");
  }

  @Override
  public void equipWeaponTransition(Weapon w) throws InvalidStateTransitionException {
    throw new InvalidStateTransitionException("Cannot equip a Weapon in the current GameState");
  }

  @Override
  public void useSpellTransition(GameCharacter target) throws InvalidStateTransitionException {
    throw new InvalidStateTransitionException("Cannot use a Spell in the current GameState");
  }

  @Override
  public void equipSpellTransition(Spell s) throws InvalidStateTransitionException {
    throw new InvalidStateTransitionException("Cannot equip a Spell in the current GameState");
  }
}
