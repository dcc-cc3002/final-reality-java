package model.character.player;

import cl.uchile.dcc.finalreality.GameController;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidStateTransitionException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
import cl.uchile.dcc.finalreality.game.states.EnemyTurn;
import cl.uchile.dcc.finalreality.game.states.Idle;
import cl.uchile.dcc.finalreality.game.states.PlayerCharacterTurn;
import cl.uchile.dcc.finalreality.model.adverse.effects.BurnedAdverseEffect;
import cl.uchile.dcc.finalreality.model.adverse.effects.PoisonAdverseEffect;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AbstractPlayerCharacterTest {
  WhiteMage whitemage;
  Knight knight;
  Sword sword;
  BlockingQueue<GameCharacter> queue;
  GameController gameController;

  @Before
  public void setUp() throws InvalidStatValueException, InvalidWeaponTypeException {
    queue = new LinkedBlockingQueue<>();
    whitemage = new WhiteMage("Yugo the WhiteMage", 1000, 60, 500, queue);
    knight = new Knight("Goultar the Knight", 5000, 300, queue);
    sword = new Sword("Smiling Sword", 20, 60);
    gameController = new GameController();
  }

  @Test
  public void getEquipTest() throws InvalidWeaponTypeException {
    assertNull("equipped Weapon should be null", knight.getEquippedWeapon());
    knight.equip(sword);
    assertEquals("The equipped Weapon should be a Sword", sword, knight.getEquippedWeapon());
    assertNotEquals("WhiteMage should not have a sword equipped",
        sword, whitemage.getEquippedWeapon());
  }

  @Test
  public void getWeightTest() throws InvalidStatValueException, InvalidWeaponTypeException {
    assertThrows(InvalidStatValueException.class, () -> whitemage.getWeight());
    knight.equip(sword);
    assertEquals("The weight of the Knight should be equals to the Sword's weight",
        sword.getWeight(), knight.getWeight());
  }
  @Test
  public void getAttackTest() throws InvalidStatValueException, InvalidWeaponTypeException {
    assertThrows(InvalidStatValueException.class, () -> whitemage.getAttack());
    knight.equip(sword);
    assertEquals("The attack of the Knight should be equals to the Sword's damage",
        sword.getDamage(), knight.getAttack());
  }

  @Test
  public void notifySubscribersDeathTest() throws InterruptedException {
    PlayerCharacter p = gameController.getPlayerCharacters().get(0);
    Thread.sleep(2100);
    assertTrue("The player should be in the queue", gameController.getTurnsQueue().contains(p));
    assertTrue("The player should be in the queue", gameController.getPlayerCharacters().contains(p));
    p.notifySubscribersDeath();
    assertFalse("The player should not be in the queue", gameController.getTurnsQueue().contains(p));
    assertFalse("The player should not be in the queue", gameController.getPlayerCharacters().contains(p));
  }

  @Test
  public void beginTurnTest() throws InvalidStateTransitionException, InvalidStatValueException, InterruptedException {
    gameController.getPlayerCharacters().add(knight);
    knight.subscribe(gameController);
    knight.setAdverseEffect(new BurnedAdverseEffect(100));
    assertEquals("The Player should not have recived poison damage", 5000, knight.getCurrentHp());
    assertEquals("The GameState should be Idle", new Idle(), gameController.getCurrentState());
    knight.beginTurn(gameController.getCurrentState());
    assertEquals("The GameState should be PlayerCharacterTurn", new PlayerCharacterTurn(knight), gameController.getCurrentState());
    assertEquals("The Player should have recived poison damage", 4900, knight.getCurrentHp());
    knight.notifySubscribersDeath();
    gameController.setCurrentState(new Idle());
    knight.beginTurn(gameController.getCurrentState());
    assertNotEquals("The next turn should not be the turn of this whitemage", new PlayerCharacterTurn(knight), gameController.getCurrentState());
  }
}