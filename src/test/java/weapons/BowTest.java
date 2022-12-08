package weapons;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Bow;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BowTest {
  Bow bow;
  Weapon bow2;
  Bow bow3;
  Axe axe;
  Thief thief;
  Engineer engineer;
  BlockingQueue<GameCharacter> queue;
  @Before
  public void setUp() throws InvalidStatValueException {
    bow = new Bow("Miauvizor's Bow", 5, 50);
    bow2 = new Bow("Miauvizor's Bow", 5, 50);
    bow3 = new Bow("Corrupted Bow", 10, 60);
    axe = new Axe("Cil's Axe", 10, 36);
    queue = new LinkedBlockingQueue<>();
    thief = new Thief("Sram the Thief", 100, 40, queue);
    engineer = new Engineer("Steamer the Engineer", 120, 30, queue);
  }

  @Test
  public void equipToThiefTest() {
    assertEquals("The returned Weapon should be an axe", bow, bow.equipToThief(thief));
  }

  @Test
  public void equipToEngineerTest() {
    assertEquals("The returned Weapon should be an axe", axe, axe.equipToEngineer(engineer));
  }

  @Test
  public void testEquals() {
    assertEquals("A Bow is not equals to itself", true, bow.equals(bow));
    assertEquals("A Bow is not equals to another bow with same parameters", true, bow.equals(bow2));
    assertNotEquals("A Bow is equals to another bow with different parameters", true, bow.equals(bow3));
    assertEquals("An Axe is the same as a Bow", false, bow.equals(axe));

  }

  @Test
  public void testHashCode() {
    assertEquals("Two equals Bows does not have the same hashCode",
        bow.hashCode(), bow2.hashCode());
    assertNotEquals("Two different Bows have the same Hashcode", axe.hashCode(), bow3.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("toString method does'nt work in the Bow class", "Bow{name='" + bow.getName() +
        "', weight=" + bow.getWeight() + ", damage=" + bow.getDamage() + "}", bow.toString());
    assertNotEquals("toString method does'nt work in the Bow class", bow.toString(), bow3.toString());
  }

}
