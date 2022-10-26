package character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.*;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.Assert.*;

public class AbstractPlayerCharacterTest {
  PlayerCharacter whitemage;
  PlayerCharacter knight;
  PlayerCharacter thief;
  Weapon sword;

  @Before
  public void setUp() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    whitemage = new WhiteMage("Yugo the WhiteMage", 1000, 60, 500, queue);
    knight = new Knight("Goultar the Knight", 5000, 300, queue);
    sword = new Sword("Smiling Sword", 20, 60);
  }

  @DisplayName("In this test we are testing the equip method and getEquippedWeapon method simultanously")
  @Test
  public void equipTest() {
    assertEquals("equipped Weapon should be null", null, knight.getEquippedWeapon());
    knight.equip(sword);
    assertEquals("The equipped Weapon should be a Sword", sword, knight.getEquippedWeapon());
    assertNotEquals("WhiteMage should not have a sword equipped",
        sword, whitemage.getEquippedWeapon());
  }

  @Test
  public void getWeightTest() {
    assertEquals("The weight should be -1 when not having a Weapon equipped",
        -1, whitemage.getWeight());
    knight.equip(sword);
    assertEquals("The weight of the Knight should be equals to the Sword's weight",
        sword.getWeight(), knight.getWeight());
  }
}