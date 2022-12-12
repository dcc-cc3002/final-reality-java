package game.states;

import cl.uchile.dcc.finalreality.GameController;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidStateTransitionException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
import cl.uchile.dcc.finalreality.game.states.EnemyTurn;
import cl.uchile.dcc.finalreality.game.states.GameState;
import cl.uchile.dcc.finalreality.game.states.Idle;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.magic.spell.Heal;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThrows;

public class EnemyTurnTest {
  EnemyTurn gamestate;
  GameState gamestate1;
  GameState gamestate2;
  GameController gameController;
  Enemy character;

  @Before
  public void setUp() throws InvalidStatValueException, InvalidWeaponTypeException {
    gameController = new GameController();
    character = new Enemy("EnemyTest", 10, 30,10,30, gameController.getTurnsQueue());
    gamestate = new EnemyTurn(character);
    gamestate1 = new EnemyTurn(character);
    gamestate2 = new Idle();
    gameController.setCurrentState(gamestate);
  }

  @Test
  public void getEnemyTest() throws InvalidStatValueException {
    assertEquals("The enemy is not the expected", character, gamestate.getEnemy());
    assertNotEquals("The enemy is not the expected", new Enemy("EnemyTest", 10, 10,10,10, gameController.getTurnsQueue()), gamestate.getEnemy());
  }

  @Test
  public void attackTest() throws InvalidStatValueException {
    assertEquals("The turn is not the expected", gamestate, gameController.getCurrentState());
    assertEquals("The Enemy should have 30 Hp", 30, gamestate.getEnemy().getCurrentHp());
    gamestate.attack(gamestate.getEnemy());
    assertEquals("The turn is not the expected", new Idle(), gameController.getCurrentState());
    assertEquals("The Enemy should have 10 Hp", 10, gamestate.getEnemy().getCurrentHp());
  }

  @Test
  public void testEquals() {
    assertEquals("The turn is not the expected", true, gamestate.equals(gamestate));
    assertEquals("The turn is not the expected", true, gamestate.equals(gamestate1));
    assertEquals("The turn is not the expected", false, gamestate.equals(gamestate2));
  }

  @Test
  public void testHashCode() {
    assertEquals("Two equals EnemyTurn does not have the same hashCode",
        gamestate.hashCode(), gamestate1.hashCode());
    assertNotEquals("Two different EnemyTurn have the same Hashcode", gamestate.hashCode(), gamestate2.hashCode());
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
