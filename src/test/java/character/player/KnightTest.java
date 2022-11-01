package character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapon.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KnightTest {
  Knight knight;
  PlayerCharacter knight2;
  Knight knight3;
  WhiteMage whitemage;
  Axe axe;
  Bow bow;
  Knife knife;
  Staff staff;
  Sword sword;
  BlockingQueue<GameCharacter> queue;

  @Before
  public void setUp() throws InvalidStatValueException {
    queue = new LinkedBlockingQueue<>();
    knight = new Knight("Goultar the Knight", 5000, 300, queue);
    knight2 = new Knight("Goultar the Knight", 5000, 300, queue);
    knight3 = new Knight("King Arthur", 20000, 300, queue);
    whitemage = new WhiteMage("Yugo the WhiteMage", 1000, 60, 500, queue);
    axe = new Axe("Cil's Axe", 10, 36);
    bow = new Bow("Miauvizor's Bow", 5, 50);
    knife = new Knife("Zeyko's Dagger's", 5, 42);
    staff = new Staff("Romboton", 6, 3, 400);
    sword = new Sword("Smiling Sword", 20, 60);
  }

  @Test
  public void equipTest() throws InvalidWeaponTypeException {
    assertNull(knight.getEquippedWeapon());
    knight.equip(sword);
    assertEquals("The Knight should have a sword equipped", sword, knight.getEquippedWeapon());
    knight.equip(axe);
    assertEquals("The Knight should have an axe equipped", axe, knight.getEquippedWeapon());
    knight.equip(knife);
    assertThrows(InvalidWeaponTypeException.class, () -> knight.equip(staff));
    assertThrows(InvalidWeaponTypeException.class, () -> knight.equip(bow));
    assertEquals("The Knight should have a knife equipped", knife, knight.getEquippedWeapon());
  }

  @Test
  public void testEquals() {
    assertEquals("A Knight is not equals to itself", true, knight.equals(knight));
    assertEquals("A Knight is not equals to another Knight with same parameters",
        true, knight.equals(knight2));
    assertNotEquals("A Knight is equals to another Knight with different parameters",
        true, knight.equals(knight3));
    assertEquals("A Knight is the same as a WhiteMage", false, knight.equals(whitemage));
  }

  @Test
  public void testHashCode() {
    assertEquals("Two equals Knights does not have the same hashCode",
        knight.hashCode(), knight2.hashCode());
    assertNotEquals("Two different Knights have the same Hashcode", knight.hashCode(), knight3.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("toString method does not work in the Knight class", "Knight{maxHp=" + knight.getMaxHp() + ", currentHp=" +
        knight.getCurrentHp() + ", defense=" + knight.getDefense() + ", name='" + knight.getName() +
        "'}", knight.toString());
    assertNotEquals("toString method does not work in the Knight class", knight.toString(), knight3.toString());
  }
}
