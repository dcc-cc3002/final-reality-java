package game.states;

import cl.uchile.dcc.finalreality.GameController;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidStateTransitionException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
import cl.uchile.dcc.finalreality.game.states.EnemyTurn;
import cl.uchile.dcc.finalreality.game.states.GameState;
import cl.uchile.dcc.finalreality.game.states.Idle;
import cl.uchile.dcc.finalreality.game.states.PlayerCharacterTurn;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.magic.spell.Heal;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Bow;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThrows;

public class PlayerCharacterTurnTest {
  PlayerCharacterTurn gamestate;
  GameState gamestate1;
  GameState gamestate2;
  GameController gameController;
  Knight character;
  Sword sword;

  @Before
  public void setUp() throws InvalidStatValueException, InvalidWeaponTypeException {
    gameController = new GameController();
    character = new Knight("Goultar", 30, 10, gameController.getTurnsQueue());
    sword = new Sword("SwordTest", 10, 30);
    character.equip(sword);
    gamestate = new PlayerCharacterTurn(character);
    gamestate1 = new PlayerCharacterTurn(character);
    gamestate2 = new Idle();
    gameController.setCurrentState(gamestate);
  }

  @Test
  public void getPlayerCharacterTest() throws InvalidStatValueException {
    assertEquals("The PlayerCharacter is not the expected", character, gamestate.getPlayerCharacter());
    assertNotEquals("The PlayerCharacter is not the expected", new Knight("Goulta", 30, 10, gameController.getTurnsQueue()), gamestate.getPlayerCharacter());
  }

  @Test
  public void attackTest() throws InvalidStatValueException {
    assertEquals("The turn is not the expected", gamestate, gameController.getCurrentState());
    assertEquals("The PlayerCharacter should have 30 Hp", 30, gamestate.getPlayerCharacter().getCurrentHp());
    gamestate.attack(gamestate.getPlayerCharacter());
    assertEquals("The turn is not the expected", new Idle(), gameController.getCurrentState());
    assertEquals("The PlayerCharacter should have 10 Hp", 10, gamestate.getPlayerCharacter().getCurrentHp());
  }

  @Test
  public void equipWeaponTest() throws InvalidWeaponTypeException {
    assertEquals("The turn is not the expected", gamestate, gameController.getCurrentState());
    assertEquals("The PlayerCharacter should a sword equipped", sword, gamestate.getPlayerCharacter().getEquippedWeapon());
    gamestate.equipWeapon(new Axe("AxeTest", 10, 10));
    assertEquals("The turn is not the expected", gamestate, gameController.getCurrentState());
    assertNotEquals("The PlayerCharacter should an axe equipped", sword, gamestate.getPlayerCharacter().getEquippedWeapon());
    assertEquals("The PlayerCharacter should an Axe equipped", new Axe("AxeTest", 10, 10), gamestate.getPlayerCharacter().getEquippedWeapon());
    assertThrows(InvalidWeaponTypeException.class, () -> gamestate.equipWeapon(new Bow("BowTest", 10, 10)));
  }

  @Test
  public void testEquals() {
    assertEquals("The turn is not the expected", true, gamestate.equals(gamestate));
    assertEquals("The turn is not the expected", true, gamestate.equals(gamestate1));
    assertEquals("The turn is not the expected", false, gamestate.equals(gamestate2));
  }

  @Test
  public void testHashCode() {
    assertEquals("Two equals PlayerCharacterTurns does not have the same hashCode",
        gamestate.hashCode(), gamestate1.hashCode());
    assertNotEquals("Two different PlayerCharacterTurns have the same Hashcode", gamestate.hashCode(), gamestate2.hashCode());
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
