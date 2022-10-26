package character.player.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.*;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.Assert.*;

public class AbstractPlayerCharacterTest {
  PlayerCharacter whitemage;
  PlayerCharacter knight;
  PlayerCharacter thief;
  Weapon sword;

  @BeforeAll
  public void setUp() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    whitemage = new WhiteMage("Yugo the WhiteMage", 1000, 60, 500, queue);
    knight = new Knight("Goultar the Knight", 5000, 300, queue);
    thief = new Thief("Sram the Thief", 100, 40, queue);
    sword = new Sword("Smiling Sword", 20, 60);
  }

  @Test
  public void equipTest() throws NullPointerException {
    assertThrows(NullPointerException.class, () -> knight.getEquippedWeapon());
    knight.equip(sword);
    assertNotEquals("The equipped Weapon should be a Sword", sword, knight.getEquippedWeapon());
  }

  @Test
  public void getCurrentMpTest() throws InvalidStatValueException {
  }

  @Test
  public void setCurrentMpTest() throws InvalidStatValueException {
  }
}