package character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class EngineerTest {
  Engineer engineer;
  PlayerCharacter engineer2;
  Engineer engineer3;
  Knight knight;
  BlockingQueue<GameCharacter> queue;

  @Before
  public void setUp() throws InvalidStatValueException {
    queue = new LinkedBlockingQueue<>();
    engineer = new Engineer("Steamer the Engineer", 120, 30, queue);
    engineer2 = new Engineer("Steamer the Engineer", 120, 30, queue);
    engineer3 = new Engineer("Merkator", 13000, 32, queue);
    knight = new Knight("Goultar the Knight", 5000, 300, queue);
  }

  @Test
  public void testEquals() {
    assertEquals("A Engineer is not equals to itself", true, engineer.equals(engineer));
    assertEquals("A Engineer is not equals to another Engineer with same parameters",
        true, engineer.equals(engineer2));
    assertNotEquals("A Engineer is equals to another Engineer with different parameters",
        true, engineer.equals(engineer3));
    assertEquals("A Engineer is the same as a Knight", false, engineer.equals(knight));
  }

  @Test
  public void testHashCode() {
    assertEquals("Two equals Engineers does not have the same hashCode",
        engineer.hashCode(), engineer2.hashCode());
    assertNotEquals("Two different Engineers have the same Hashcode", engineer.hashCode(), engineer3.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("toString method does not work in the Engineer class", "Engineer{maxHp=" + engineer.getMaxHp() + ", currentHp=" +
        engineer.getCurrentHp() + ", defense=" + engineer.getDefense() + ", name='" + engineer.getName() +
        "'}", engineer.toString());
    assertNotEquals("toString method does not work in the Engineer class", engineer.toString(), engineer3.toString());
  }
}
