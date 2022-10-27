package character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ThiefTest {
  Thief thief;
  PlayerCharacter thief2;
  Thief thief3;
  Knight knight;
  BlockingQueue<GameCharacter> queue;

  @Before
  public void setUp() throws InvalidStatValueException {
    queue = new LinkedBlockingQueue<>();
    thief = new Thief("Sram the Thief", 100, 40, queue);
    thief2 = new Thief("Sram the Thief", 100, 40, queue);
    thief3 = new Thief("Mars", 12, 220, queue);
    knight = new Knight("Goultar the Knight", 5000, 300, queue);
  }

  @Test
  public void testEquals() {
    assertEquals("A Thief is not equals to itself", true, thief.equals(thief));
    assertEquals("A Thief is not equals to another Thief with same parameters",
        true, thief.equals(thief2));
    assertNotEquals("A Thief is equals to another Thief with different parameters",
        true, thief.equals(thief3));
    assertEquals("A Thief is the same as a Knight", false, thief.equals(knight));
  }

  @Test
  public void testHashCode() {
    assertEquals("Two equals Thiefs does not have the same hashCode",
        thief.hashCode(), thief2.hashCode());
    assertNotEquals("Two different Thiefs have the same Hashcode", thief.hashCode(), thief3.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("toString method does not work in the Thief class", "Thief{maxHp=" + thief.getMaxHp() + ", currentHp=" +
        thief.getCurrentHp() + ", defense=" + thief.getDefense() + ", name='" + thief.getName() +
        "'}", thief.toString());
    assertNotEquals("toString method does not work in the Thief class", thief.toString(), thief3.toString());
  }
}
