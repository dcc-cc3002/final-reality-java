package game.states;

import cl.uchile.dcc.finalreality.GameController;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidStateTransitionException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
import cl.uchile.dcc.finalreality.game.states.GameState;
import cl.uchile.dcc.finalreality.game.states.Idle;
import cl.uchile.dcc.finalreality.game.states.PlayerCharacterTurn;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.magic.spell.Heal;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AbstractGameStateTest {
  GameState gamestate;
  GameState gamestate1;
  GameController gameController;
  Knight character;

  @Before
  public void setUp() throws InvalidStatValueException, InvalidWeaponTypeException {
    gamestate = new Idle();
    gameController = new GameController();
    character = new Knight("KnightTest", 10, 10, gameController.getTurnsQueue());
    gamestate1 = new PlayerCharacterTurn(character);

  }

  @Test
  public void changeStateTest() {
    GameState gameState2 = gameController.getCurrentState();
    assertEquals("The context is the expected", gameState2.getContext(), gameController);
    gameState2.changeState(gamestate1);
    assertEquals("The context is the expected", gamestate1.getContext(), gameController);
    assertEquals("The context is the expected", gameState2.getContext(), gameController);
  }

  @Test
  public void getContextTest() {
    assertNotEquals("The context is not initialized", gamestate.getContext(), gameController);
    gamestate.setContext(gameController);
    assertEquals("The context is initialized", gamestate.getContext(), gameController);
    assertEquals("The context is not initialized", gamestate1.getContext(), null);
  }

  @Test
  public void setContextTest() {
    assertNotEquals("The context is not initialized", gamestate.getContext(), gameController);
    gamestate.setContext(gameController);
    assertEquals("The context is initialized", gamestate.getContext(), gameController);
    assertEquals("The context is not initialized", gamestate1.getContext(), null);
    gamestate1.setContext(gameController);
    assertEquals("The context is initialized", gamestate1.getContext(), gameController);
  }

  @Test
  public void attackTest() {
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
