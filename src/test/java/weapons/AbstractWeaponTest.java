package weapons;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapon.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class AbstractWeaponTest {
  Weapon knife;
  Weapon sword;
  Weapon staff;
  Weapon axe;
  Weapon bow;
  Knight knight;
  WhiteMage whitemage;
  BlockingQueue<GameCharacter> queue;

  @Before
  public void setUp() throws InvalidStatValueException {
    knife = new Knife("Zeyko's Dagger's", 5, 42);
    sword = new Sword("Zeyko's Dagger's", 20, 60);
    staff = new Staff("Romboton", 6, 3, 400);
    axe = new Axe("Cil's Axe", 10, 36);
    bow = new Bow("Miauvizor's Bow", 5, 60);
    queue = new LinkedBlockingQueue<>();
    knight = new Knight("Goultar the Knight", 5000, 300, queue);
    whitemage = new WhiteMage("Yugo the WhiteMage", 1000, 60, 500, queue);
  }

  @DisplayName("In this test we are going to test every equipTo method in AbstractWeapon")
  @Test
  public void equipToTest() {
    assertThrows(InvalidWeaponTypeException.class, () -> sword.equipToWhiteMage(whitemage));
    assertThrows(InvalidWeaponTypeException.class, () -> bow.equipToWhiteMage(whitemage));
    assertThrows(InvalidWeaponTypeException.class, () -> axe.equipToWhiteMage(whitemage));
    assertThrows(InvalidWeaponTypeException.class, () -> knife.equipToWhiteMage(whitemage));
    assertThrows(InvalidWeaponTypeException.class, () -> staff.equipToKnight(knight));
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
