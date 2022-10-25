package weapons;

import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Bow;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BowTest {
  Bow bow;
  Weapon bow2;
  Bow bow3;
  Axe axe;

  @Before
  public void setUp() {
    bow = new Bow("Miauvizor's Bow", 5, 50);
    bow2 = new Bow("Miauvizor's Bow", 5, 50);
    bow3 = new Bow("Corrupted Bow", 10, 60);
    axe = new Axe("Cil's Axe", 10, 36);
  }

  @Test
  public void testEquals() {
    assertEquals("A Bow is not equals to itself", true, bow.equals(bow));
    assertEquals("A Bow is not equals to another Axe with same parameters", true, bow.equals(bow2));
    assertNotEquals("An Axe is equals to another bow with different parameters", true, bow.equals(bow3));
    assertEquals("An Axe is the same as a Bow", false, axe.equals(bow));

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
