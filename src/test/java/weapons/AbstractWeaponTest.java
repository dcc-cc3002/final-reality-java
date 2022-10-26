package weapons;

import cl.uchile.dcc.finalreality.model.weapon.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AbstractWeaponTest {
  Weapon knife;
  Weapon sword;
  Weapon staff;
  Weapon axe;
  Weapon bow;

  @Before
  public void setUp() {
    knife = new Knife("Zeyko's Dagger's", 5, 42);
    sword = new Sword("Zeyko's Dagger's", 20, 60);
    staff = new Staff("Romboton", 6, 3, 400);
    axe = new Axe("Cil's Axe", 10, 36);
    bow = new Bow("Miauvizor's Bow", 5, 60);
  }

  @Test
  public void getNameTest() {
    assertEquals(sword.getName(), knife.getName(), "The Weapon's name is not the same");
    assertNotEquals(staff.getName(), axe.getName(), "The Weapon's name is equals when it should not");
  }

  @Test
  public void getWeightTest() {
    assertTrue(knife.getWeight() == bow.getWeight(), "The Weapon's weight is not the same");
    assertFalse(staff.getWeight() == axe.getWeight(), "The Weapon's weights match when it should'nt");
  }

  @Test
  public void getDamageTest() {
    assertTrue(sword.getDamage() == bow.getDamage(), "The Weapon's attack is not the same");
    assertFalse(staff.getDamage() == knife.getDamage(), "The Weapon's attacks match when it should'nt");
  }
}
