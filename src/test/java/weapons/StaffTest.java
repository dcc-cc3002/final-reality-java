package weapons;

import cl.uchile.dcc.finalreality.model.weapon.Staff;
import cl.uchile.dcc.finalreality.model.weapon.Bow;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class StaffTest {
  Staff staff;
  Weapon staff2;
  Staff staff3;
  Bow bow;

  @Before
  public void setUp() {
    staff = new Staff("Romboton", 6, 3, 400);
    staff2 = new Staff("Romboton", 6, 3, 400);
    staff3 = new Staff("Zoth Manitu's Staff", 3, 1, 70);
    bow = new Bow("Miauvizor's Bow", 5, 50);
  }

  @Test
  public void testEquals() {
    assertEquals("An Staff is not equals to itself", true, staff.equals(staff));
    assertEquals("An Staff is not equals to another Staff with same parameters", true, staff.equals(staff2));
    assertNotEquals("An Staff is equals to another staff with diferent parameters", true, staff3.equals(staff));
    assertEquals("An Staff is the same as a Bow", false, staff.equals(bow));

  }

  @Test
  public void testHashCode() {
    assertEquals("Two equals Staff's does not have the same hashCode",
        staff.hashCode(), staff2.hashCode());
    assertNotEquals("Two different Staff's have the same Hashcode", staff.hashCode(), staff3.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("toString method does not work in the Staff class", "Staff{name='" + staff.getName() +
        "', weight=" + staff.getWeight() + ", damage=" + staff.getDamage() + ", magicDamage=" +
        staff.getMagicDamage() + "}", staff.toString());
    assertNotEquals("toString method does'nt work in the Staff class", staff3.toString(), staff.toString());
  }

}
