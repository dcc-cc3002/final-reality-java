package game.states;

import cl.uchile.dcc.finalreality.GameController;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidStateTransitionException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
import cl.uchile.dcc.finalreality.game.states.EnemyTurn;
import cl.uchile.dcc.finalreality.game.states.GameState;
import cl.uchile.dcc.finalreality.game.states.Idle;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.magic.spell.Heal;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import java.util.Random;
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
  int seed;
  Random rng;

  @Before
  public void setUp() throws InvalidStatValueException, InvalidWeaponTypeException {
    gameController = new GameController();
    character = new Enemy("EnemyTest", 10, 30,10,30, gameController.getTurnsQueue());
    gamestate = new EnemyTurn(character);
    gamestate1 = new EnemyTurn(character);
    gamestate2 = new Idle();
    gameController.setCurrentState(gamestate);
    seed = 128342;
    rng = new Random(seed);
  }

  @Test
  public void getEnemyTest() throws InvalidStatValueException {
    assertEquals("The enemy is not the expected", character, gamestate.getEnemy());
    assertNotEquals("The enemy is not the expected", new Enemy("EnemyTest", 10, 10,10,10, gameController.getTurnsQueue()), gamestate.getEnemy());
  }

  @Test
  public void autoAttackTest() throws InvalidStatValueException {
    gamestate.setRandom(new Random(12345));
    assertEquals("The turn is not the expected", gamestate, gameController.getCurrentState());
    PlayerCharacter player = gameController.getPlayerCharacters().get(1);
    assertEquals("The Player should have 50 Hp", 50, player.getCurrentHp());
    gamestate.autoAttack();
    assertEquals("The turn is not the expected", new Idle(), gameController.getCurrentState());
    assertEquals("The Player should have 50-22 = 28 Hp", 28, player.getCurrentHp());
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
  public void setGetRandomTest() {
    gamestate.setRandom(rng);
    assertEquals(new Random(128342).nextInt(4), gamestate.getRandom().nextInt(4));
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
