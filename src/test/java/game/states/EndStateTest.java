package game.states;

import cl.uchile.dcc.finalreality.GameController;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidStateTransitionException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
import cl.uchile.dcc.finalreality.game.states.EndState;
import cl.uchile.dcc.finalreality.game.states.GameState;
import cl.uchile.dcc.finalreality.game.states.Idle;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.magic.spell.Heal;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThrows;

public class EndStateTest {
  EndState gamestate;
  GameState gamestate1;
  GameState gamestate2;
  GameController gameController;
  Enemy character;

  @Before
  public void setUp() throws InvalidStatValueException, InvalidWeaponTypeException {
    gameController = new GameController();
    gamestate = new EndState();
    gamestate1 = new EndState();
    gamestate2 = new Idle();
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
    assertEquals("Two equals EndTurn does not have the same hashCode",
        gamestate.hashCode(), gamestate1.hashCode());
    assertNotEquals("Two different EndTurn have the same Hashcode", gamestate.hashCode(), gamestate2.hashCode());
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
  public void nextTurnTest() {
    assertThrows(InvalidStateTransitionException.class, () -> gamestate1.nextTurn());
  }
}
