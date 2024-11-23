package game.states;

import cl.uchile.dcc.finalreality.GameController;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidStateTransitionException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
import cl.uchile.dcc.finalreality.game.states.*;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;
import cl.uchile.dcc.finalreality.model.magic.spell.Heal;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThrows;

public class IdleTest {
  Idle gamestate;
  GameState gamestate1;
  GameState gamestate2;
  GameController gameController;
  Enemy character;

  @Before
  public void setUp() throws InvalidStatValueException, InvalidWeaponTypeException {
    gameController = new GameController();
    gamestate = new Idle();
    gamestate1 = new Idle();
    gamestate2 = new EndState();
    gameController.setCurrentState(gamestate);
  }

  @Test
  public void testEquals() {
    assertEquals("The turn is not the expected", true, gamestate.equals(gamestate));
    assertEquals("The turn is not the expected", true, gamestate.equals(gamestate1));
    assertEquals("The turn is not the expected", false, gamestate.equals(gamestate2));
  }

  @Test
  public void testHashCode() {
    assertEquals("Two equals IdleTurns does not have the same hashCode",
        gamestate.hashCode(), gamestate1.hashCode());
    assertNotEquals("Two different IdleTurns have the same Hashcode", gamestate.hashCode(), gamestate2.hashCode());
  }

  @Test
  public void attackTest() throws InvalidStatValueException {
    assertThrows(InvalidStateTransitionException.class, () -> gamestate.attack(character));
  }

  @Test
  public void equipWeaponTest() {
    assertThrows(InvalidStateTransitionException.class, () -> gamestate.equipWeapon(new Sword("Sword", 10, 10)));
  }

  @Test
  public void useSpellTest() {
    assertThrows(InvalidStateTransitionException.class, () -> gamestate.useSpell(character));
  }

  @Test
  public void equipSpellTest() {
    assertThrows(InvalidStateTransitionException.class, () -> gamestate.equipSpell(new Heal()));
  }

  @Test
  public void nextTurnTest() throws InvalidStateTransitionException, InvalidStatValueException, InterruptedException {
    assertEquals("The turn is not the expected", gamestate, gameController.getCurrentState());
    gamestate.nextTurn();
    assertNotEquals("The turn is not the expected", gamestate, gameController.getCurrentState());
    assertEquals("The turn is not the expected",
        new PlayerCharacterTurn(gameController.getPlayerCharacters().get(3)), gameController.getCurrentState());
    gamestate.nextTurn();
    assertNotEquals("The turn is not the expected", gamestate, gameController.getCurrentState());
  }
}
