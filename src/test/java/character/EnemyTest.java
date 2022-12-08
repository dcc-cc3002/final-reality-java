package character;

import cl.uchile.dcc.finalreality.GameController;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.*;
import static org.junit.Assert.*;

public class EnemyTest {
  Enemy enemy;
  GameCharacter enemy2;
  Enemy enemy3;
  GameCharacter engineer;
  BlockingQueue<GameCharacter> queue;
  GameController gameController;

  @Before
  public void setUp() throws InvalidStatValueException, InvalidWeaponTypeException {
    queue = new LinkedBlockingQueue<>();
    enemy = new Enemy("Comte Harebourg the Enemy", 25, 13000, 23, 400, queue);
    enemy2 = new Enemy("Comte Harebourg the Enemy", 25, 13000, 23, 400, queue);
    enemy3 = new Enemy("Ganondorf", 35, 5000, 20, 300, queue);
    engineer = new Engineer("Steamer the Engineer", 120, 30, queue);
    gameController = new GameController();
  }

  @Test
  public void getWeightTest() {
    assertEquals("The weight does not equals to the expected value", 25, enemy.getWeight());
    assertNotEquals("The weight should be different", enemy3.getWeight(), enemy.getWeight());
  }

  @Test
  public void getAttackTest() {
    assertEquals("The attack does not equals to the expected value", 400, enemy.getAttack());
    assertNotEquals("The attack should be different", enemy3.getAttack(), enemy.getAttack());
  }

  @Test
  public void equalsTest() {
    assertEquals("A Enemy is not equals to itself", true, enemy.equals(enemy));
    assertEquals("A Enemy is not equals to another Enemy with same parameters",
        true, enemy.equals(enemy2));
    assertNotEquals("A Enemy is equals to another Enemy with different parameters",
        true, enemy.equals(enemy3));
    assertEquals("A Enemy is the same as a Engineer", false, enemy.equals(engineer));
  }

  @Test
  public void hashCodeTest() {
    assertEquals("Two equals Enemys does not have the same hashCode",
        enemy.hashCode(), enemy2.hashCode());
    assertNotEquals("Two different Enemys have the same Hashcode", enemy.hashCode(), enemy3.hashCode());
  }

  @Test
  public void toStringTest() {
    assertEquals("toString method does not work in the Enemy class", "Enemy{maxHp=" +
        enemy.getMaxHp() + ", currentHp=" + enemy.getCurrentHp() + ", defense=" + enemy.getDefense() +
        ", name='" + enemy.getName() + "', weight=" + enemy.getWeight() + ", attack=" +
        enemy.getAttack() + "}", enemy.toString());
    assertNotEquals("toString method does not work in the Enemy class", enemy.toString(), enemy3.toString());
  }

  @Test
  public void notifySubscribersDeathTest() {
    Enemy e = gameController.getEnemies().get(0);
    assertTrue("The enemy should be in the queue", gameController.getTurnsQueue().contains(e));
    assertTrue("The enemy should be in the queue", gameController.getEnemies().contains(e));
    e.notifySubscribersDeath();
    assertFalse("The enemy should not be in the queue", gameController.getTurnsQueue().contains(e));
    assertFalse("The enemy should not be in the queue", gameController.getEnemies().contains(e));
  }
}
