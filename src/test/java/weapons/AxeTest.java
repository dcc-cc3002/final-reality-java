package weapons;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Bow;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;


public class AxeTest {
  Axe axe;
  Weapon axe2;
  Axe axe3;
  Bow bow;
  Knight knight;
  Engineer engineer;
  BlockingQueue<GameCharacter> queue;

  @Before
  public void setUp() throws InvalidStatValueException {
    axe = new Axe("Cil's Axe", 10, 36);
    axe2 = new Axe("Cil's Axe", 10, 36);
    axe3 = new Axe("Debutant's Axe", 10, 8);
    bow = new Bow("Miauvizor's Bow", 5, 50);
    queue = new LinkedBlockingQueue<>();
    knight = new Knight("Goultar the Knight", 5000, 300, queue);
    engineer = new Engineer("Steamer the Engineer", 120, 30, queue);
  }

  @Test
  public void equipToKnightTest() {
    assertEquals("The returned Weapon should be an axe", axe, axe.equipToKnight(knight));
  }

  @Test
  public void equipToEngineerTest() {
    assertEquals("The returned Weapon should be an axe", axe, axe.equipToEngineer(engineer));
  }

  @Test
  public void testEquals() {
    assertEquals("An Axe is not equals to itself", true, axe.equals(axe));
    assertEquals("An Axe is not equals to another Axe with same parameters", true, axe.equals(axe2));
    assertNotEquals("An Axe is equals to another axe with diferent name and attack value", true, axe3.equals(axe));
    assertEquals("An Axe is the same as a Bow", false, axe.equals(bow));

  }

  @Test
  public void testHashCode() {
    assertEquals("Two equals Axe's does not have the same hashCode",
        axe.hashCode(), axe2.hashCode());
    assertNotEquals("Two different Axe's have the same Hashcode", axe.hashCode(), axe3.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("toString method does'nt work in the Axe class", "Axe{name='" + axe.getName() +
        "', weight=" + axe.getWeight() + ", damage=" + axe.getDamage() + "}", axe.toString());
    assertNotEquals("toString method does'nt work in the Axe class", axe3.toString(), axe.toString());
  }

}
