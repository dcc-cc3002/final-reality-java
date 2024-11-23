package model.weapons;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import cl.uchile.dcc.finalreality.model.weapon.Bow;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SwordTest {
  Sword sword;
  Weapon sword2;
  Sword sword3;
  Bow bow;
  Knight knight;
  Thief thief;
  BlockingQueue<GameCharacter> queue;

  @Before
  public void setUp() throws InvalidStatValueException {
    sword = new Sword("Smiling Sword", 20, 60);
    sword2 = new Sword("Smiling Sword", 20, 60);
    sword3 = new Sword("Excalibur", 20, 100);
    bow = new Bow("Miauvizor's Bow", 5, 50);
    queue = new LinkedBlockingQueue<>();
    knight = new Knight("Goultar the Knight", 5000, 300, queue);
    thief = new Thief("Sram the Thief", 100, 40, queue);
  }

  @Test
  public void equipToThiefTest() {
    assertEquals("The returned Weapon should be a Sword", sword, sword.equipToThief(thief));
  }

  @Test
  public void equipToKnightTest() {
    assertEquals("The returned Weapon should be a Sword", sword, sword.equipToKnight(knight));
  }

  @Test
  public void testEquals() {
    assertEquals("An Sword is not equals to itself", true, sword.equals(sword));
    assertEquals("An Sword is not equals to another Sword with same parameters", true, sword.equals(sword2));
    assertNotEquals("An Sword is equals to another Sword with diferent name and weight value", true, sword3.equals(sword));
    assertEquals("An Sword is the same as a Bow", false, sword.equals(bow));

  }

  @Test
  public void testHashCode() {
    assertEquals("Two equals Sword's does not have the same hashCode",
        sword.hashCode(), sword2.hashCode());
    assertNotEquals("Two different Sword's have the same Hashcode", sword.hashCode(), sword3.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("toString method does'nt work in the Sword class", "Sword{name='" + sword.getName() +
        "', weight=" + sword.getWeight() + ", damage=" + sword.getDamage() + "}", sword.toString());
    assertNotEquals("toString method does'nt work in the Sword class", sword3.toString(), sword.toString());
  }

}
