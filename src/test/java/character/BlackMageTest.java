package character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BlackMageTest {
  BlackMage blackmage;
  PlayerCharacter blackmage2;
  BlackMage blackmage3;
  Knight knight;

  @Before
  public void setUp() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    blackmage = new BlackMage("Nox the BlackMage", 2000, 150, 200, queue);
    blackmage2 = new BlackMage("Nox the BlackMage", 2000, 150, 200, queue);
    blackmage3 = new BlackMage("Dark Mateu", 1000, 60, 200, queue);
    knight = new Knight("Goultar the Knight", 5000, 300, queue);
  }

  @Test
  public void testEquals() {
    assertEquals("A BlackMage is not equals to itself", true, blackmage.equals(blackmage));
    assertEquals("A BlackMage is not equals to another BlackMage with same parameters",
        true, blackmage.equals(blackmage2));
    assertNotEquals("A BlackMage is equals to another BlackMage with different parameters",
        true, blackmage.equals(blackmage3));
    assertEquals("A BlackMage is the same as a Knight", false, blackmage.equals(knight));
  }

  @Test
  public void testHashCode() {
    assertEquals("Two equals Blackmages does not have the same hashCode",
        blackmage.hashCode(), blackmage2.hashCode());
    assertNotEquals("Two different BlackMages have the same Hashcode", blackmage.hashCode(), blackmage3.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("toString method does'nt work in the Bow class", "BlackMage{currentMp=" + blackmage.getCurrentMp() +
        ", maxMp=" + blackmage.getMaxMp() + ", maxHp=" + blackmage.getMaxHp() + ", currentHp=" +
        blackmage.getCurrentHp() + ", defense=" + blackmage.getDefense() + ", name='" + blackmage.getName() +
        "'}", blackmage.toString());
    assertNotEquals("toString method does'nt work in the Bow class", blackmage.toString(), blackmage3.toString());
  }
}
