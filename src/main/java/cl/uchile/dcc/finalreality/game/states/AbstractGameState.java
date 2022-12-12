package cl.uchile.dcc.finalreality.game.states;

import cl.uchile.dcc.finalreality.GameController;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidStateTransitionException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.magic.spell.Spell;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract Class that throws an exception by default when a transition is not expected in
 * a subclass.
 */
public class AbstractGameState implements GameState {
  protected GameController context;

  @Override
  public void changeState(GameState s) {
    context.setCurrentState(s);
  }

  @Override
  public void setContext(GameController context) {
    this.context = context;
  }

  @Override
  public GameController getContext() {
    return context;
  }

  @Override
  public void attack(GameCharacter target)
      throws InvalidStateTransitionException, InvalidStatValueException {
    throw new InvalidStateTransitionException("Cannot attack in the current GameState");
  }

  @Override
  public void equipWeapon(Weapon w)
      throws InvalidStateTransitionException, InvalidWeaponTypeException {
    throw new InvalidStateTransitionException("Cannot equip a Weapon in the current GameState");
  }

  @Override
  public void useSpell(GameCharacter target) throws InvalidStateTransitionException {
    throw new InvalidStateTransitionException("Cannot use a Spell in the current GameState");
  }

  @Override
  public void equipSpell(Spell s) throws InvalidStateTransitionException {
    throw new InvalidStateTransitionException("Cannot equip a Spell in the current GameState");
  }

  @Override
  public void nextTurn()
      throws InvalidStateTransitionException, InterruptedException, InvalidStatValueException {
    throw new InvalidStateTransitionException("Cant use nextTurn method in this GameState");
  }
}
