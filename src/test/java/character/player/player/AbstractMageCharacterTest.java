package character.player.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AbstractMageCharacterTest {
  MageCharacter whitemage;
  MageCharacter blackmage;

  @Before
  public void setUp() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    whitemage = new WhiteMage("Yugo the WhiteMage", 1000, 60, 500, queue);
    blackmage = new BlackMage("Nox the BlackMage", 2000, 150, 200, queue);
  }

  @Test
  public void getMaxMpTest() throws InvalidStatValueException {
    assertEquals("The MaxMp value does not equal to the expected", 500, whitemage.getMaxMp());
    whitemage.setCurrentMp(400);
    assertNotEquals("The MaxMp is equals when it should not", 400, whitemage.getMaxMp());
  }
}
