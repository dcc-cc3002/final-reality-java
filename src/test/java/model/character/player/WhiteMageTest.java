package model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThrows;

public class WhiteMageTest {
  WhiteMage whitemage;
  PlayerCharacter whitemage2;
  WhiteMage whitemage3;
  Knight knight;
  Axe axe;
  Bow bow;
  Knife knife;
  Staff staff;
  Sword sword;
  BlockingQueue<GameCharacter> queue;

  @Before
    public void setUp() throws InvalidStatValueException {
      queue = new LinkedBlockingQueue<>();
      whitemage = new WhiteMage("Yugo the WhiteMage", 1000, 60, 500, queue);
      whitemage2 = new WhiteMage("Yugo the WhiteMage", 1000, 60, 500, queue);
      whitemage3 = new WhiteMage("Yiruz the Eliotrop", 4200, 20, 600, queue);
      knight = new Knight("Goultar the Knight", 5000, 300, queue);
      axe = new Axe("Cil's Axe", 10, 36);
      bow = new Bow("Miauvizor's Bow", 5, 50);
      knife = new Knife("Zeyko's Dagger's", 5, 42);
      staff = new Staff("Romboton", 6, 3, 400);
      sword = new Sword("Smiling Sword", 20, 60);
    }

  @Test
  public void equipTest() throws InvalidWeaponTypeException {
    assertNull(whitemage.getEquippedWeapon());
    whitemage.equip(staff);
    assertThrows(InvalidWeaponTypeException.class, () -> whitemage.equip(knife));
    assertThrows(InvalidWeaponTypeException.class, () -> whitemage.equip(bow));
    assertThrows(InvalidWeaponTypeException.class, () -> whitemage.equip(axe));
    assertThrows(InvalidWeaponTypeException.class, () -> whitemage.equip(sword));
    assertEquals("The Whitemage should have a staff equipped", staff, whitemage.getEquippedWeapon());
  }

    @Test
    public void testEquals() {
      assertEquals("A WhiteMage is not equals to itself", true, whitemage.equals(whitemage));
      assertEquals("A WhiteMage is not equals to another WhiteMage with same parameters",
          true, whitemage.equals(whitemage2));
      assertNotEquals("A WhiteMage is equals to another WhiteMage with different parameters",
          true, whitemage.equals(whitemage3));
      assertEquals("A WhiteMage is the same as a Knight", false, whitemage.equals(knight));
    }

    @Test
    public void testHashCode() {
      assertEquals("Two equals WhiteMages does not have the same hashCode",
          whitemage.hashCode(), whitemage2.hashCode());
      assertNotEquals("Two different Whitemages have the same Hashcode", whitemage.hashCode(), whitemage3.hashCode());
    }

    @Test
    public void testToString() {
      assertEquals("toString method does not work in the WhiteMage class", "WhiteMage{currentMP=" + whitemage.getCurrentMp() +
          ", maxMp=" + whitemage.getMaxMp() + ", maxHp=" + whitemage.getMaxHp() + ", currentHp=" +
          whitemage.getCurrentHp() + ", defense=" + whitemage.getDefense() + ", name='" + whitemage.getName() +
          "'}", whitemage.toString());
      assertNotEquals("toString method does'nt work in the WhiteMage class", whitemage.toString(), whitemage3.toString());
    }
}
