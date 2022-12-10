package model.character;

import cl.uchile.dcc.finalreality.GameController;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
import cl.uchile.dcc.finalreality.model.adverse.effects.AdverseEffect;
import cl.uchile.dcc.finalreality.model.adverse.effects.NullAdverseEffect;
import cl.uchile.dcc.finalreality.model.adverse.effects.ParalyzeAdverseEffect;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Bow;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AbstractCharacterTest {
  GameCharacter enemy;
  Engineer engineer;
  GameCharacter whitemage;
  Thief thief;
  BlockingQueue<GameCharacter> queue;
  Axe axe;
  Bow bow;
  AdverseEffect adverseEffect;
  GameController gameController;

  @Before
  public void setUp() throws InvalidStatValueException, InvalidWeaponTypeException {
    queue = new LinkedBlockingQueue<>();
    enemy = new Enemy("Comte Harebourg the Enemy", 25, 13000, 23, 400, queue);
    engineer = new Engineer("Steamer the Engineer", 120, 30, queue);
    whitemage = new WhiteMage("Yugo the WhiteMage", 1000, 60, 500, queue);
    thief = new Thief("Sram the Thief", 100, 40, queue);
    axe = new Axe("Cil's Axe", 18, 36);
    bow = new Bow("Buhorado's Plume", 2, 50);
    adverseEffect = new NullAdverseEffect();
    whitemage.setAdverseEffect(adverseEffect);
    gameController = new GameController();
  }

  @Test
  public void setCurrentHpTest() throws InvalidStatValueException {
    whitemage.setCurrentHp(0);
    assertEquals("setCurrentHp is not working as intended", 0, whitemage.getCurrentHp());
    assertThrows(InvalidStatValueException.class, () -> enemy.setCurrentHp(-1));
    assertThrows(InvalidStatValueException.class, () -> engineer.setCurrentHp(whitemage.getMaxHp()+1));
    assertNotEquals("setCurrentHp should not be equals", whitemage.getMaxHp(), whitemage.getCurrentHp());
  }

  @Test
  public void getNameTest() {
    assertEquals("The name does not equals to the expected value", "Comte Harebourg the Enemy", enemy.getName());
    assertNotEquals("The name should be different", thief.getName(), enemy.getName());
  }

  @Test
  public void getCurrentHpTest() throws InvalidStatValueException {
    assertEquals("The CurrentHp does not equals to the expected value", engineer.getMaxHp(), engineer.getCurrentHp());
    engineer.setCurrentHp(engineer.getMaxHp()/10);
    assertEquals("The CurrentHp does not equals to the expected value", 12, engineer.getCurrentHp());
    enemy.setCurrentHp(enemy.getMaxHp()/10);
    assertNotEquals("The CurrentHp should be different", enemy.getMaxHp(), enemy.getCurrentHp());
  }

  @Test
  public void getMaxHpTest() throws InvalidStatValueException {
    assertEquals("The MaxHp does not equals to the expected value", 120, engineer.getMaxHp());
    engineer.setCurrentHp(engineer.getMaxHp()/10);
    assertNotEquals("The MaxHp does not equals to the expected value",
        engineer.getCurrentHp(), engineer.getMaxHp());
    thief.setCurrentHp(thief.getMaxHp()/10);
    assertNotEquals("The MaxHp should be different", thief.getCurrentHp(), thief.getMaxHp());
  }

  @Test
  public void getDefenseTest() {
    assertEquals("The defense does not equals to the expected value", 60, whitemage.getDefense());
    assertNotEquals("The defense should be different", whitemage.getDefense(), enemy.getDefense());
  }
  @Test
  public void waitTurn_addToQueue_Test() throws InterruptedException, InvalidStatValueException, InvalidWeaponTypeException {
    assertTrue("The queue should be empty", queue.isEmpty());
    assertThrows(InvalidStatValueException.class, () -> thief.waitTurn());
    assertTrue("The queue should still be empty", queue.isEmpty());
    engineer.equip(axe);
    engineer.waitTurn();
    thief.equip(bow);
    thief.waitTurn();
    Thread.sleep(2500);
    assertFalse("The queue should not be empty", queue.isEmpty());
    assertEquals("The thief should be exiting the queue", thief, queue.poll());
    assertEquals("The engineer should be exiting the queue", engineer, queue.poll());
    assertTrue("The queue should be empty", queue.isEmpty());
  }

  @Test
  public void getAdverseEffectTest() {
    assertEquals("The AdverseEffect does not equals to the expected value", whitemage.getAdverseEffect(), adverseEffect);
    AdverseEffect paralyzed = new ParalyzeAdverseEffect();
    whitemage.setAdverseEffect(paralyzed);
    assertNotEquals("The AdverseEffect should be different", whitemage.getAdverseEffect(), adverseEffect);
    assertEquals("The AdverseEffect does not equals to the expected value", whitemage.getAdverseEffect(), paralyzed);
  }

  @Test
  public void setAdverseEffectTest() {
    AdverseEffect paralyzed = new ParalyzeAdverseEffect();
    whitemage.setAdverseEffect(paralyzed);
    assertEquals("The AdverseEffect does not equals to the expected value", whitemage.getAdverseEffect(), paralyzed);
    assertNotEquals("The AdverseEffect should be different", whitemage.getAdverseEffect(), adverseEffect);
    whitemage.setAdverseEffect(adverseEffect);
    assertNotEquals("The AdverseEffect should be different", whitemage.getAdverseEffect(), paralyzed);
  }

  @Test
  public void subscribeAndGetSubscribersTest() {
    assertTrue("There should be no subscriber", engineer.getSubscribers().isEmpty());
    engineer.subscribe(gameController);
    assertFalse("There should be a subscriber", engineer.getSubscribers().isEmpty());
    assertEquals("The subscribers must be only gameController", gameController, engineer.getSubscribers().get(0));
  }
}
