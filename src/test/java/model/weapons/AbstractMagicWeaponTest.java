package model.weapons;

import cl.uchile.dcc.finalreality.model.weapon.MagicWeapon;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AbstractMagicWeaponTest {
  MagicWeapon staff;
  Staff staff2;

  @Before
  public void setUp() {
    staff = new Staff("Romboton", 6, 3, 400);
    staff2 = new Staff("Zoth Manitu's Staff", 3, 1, 70);
  }

  @Test
  public void testGetMagicDamage() {
    assertEquals("The MagicDamage value is not equal to the required value", 400, staff.getMagicDamage());
    assertNotEquals("The MagicDamage is equals to a not expected value", 0, staff2.getMagicDamage());
    assertNotEquals("The MagicDamage value is equals to the wronng value", staff.getMagicDamage(), staff2.getMagicDamage());
  }
}