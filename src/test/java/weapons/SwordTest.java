package weapons;

import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Bow;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SwordTest {
  Axe axe;
  Weapon axe2;
  Axe axe3;
  Bow bow;

  @Before
  public void setUp() {
    axe = new Axe("Cil's Axe", 10, 36);
    axe2 = new Axe("Cil's Axe", 10, 36);
    axe3 = new Axe("Debutant's Axe", 10, 8);
    bow = new Bow("Miauvizor's Bow", 5, 50);
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
