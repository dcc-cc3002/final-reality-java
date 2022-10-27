package character.player;

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
  BlockingQueue<GameCharacter> queue;

  @Before
  public void setUp() throws InvalidStatValueException {
    queue = new LinkedBlockingQueue<>();
    whitemage = new WhiteMage("Yugo the WhiteMage", 1000, 60, 500, queue);
    blackmage = new BlackMage("Nox the BlackMage", 2000, 150, 200, queue);
  }

  @Test
  public void getMaxMpTest() throws InvalidStatValueException {
    assertEquals("The MaxMp value does not equal to the expected", 500, whitemage.getMaxMp());
    whitemage.setCurrentMp(400);
    assertNotEquals("The MaxMp is equals when it should not", 400, whitemage.getMaxMp());
  }

  @Test
  public void getCurrentMpTest() throws InvalidStatValueException {
    assertEquals("The currentMp does not equal to the expected", whitemage.getMaxMp(), whitemage.getCurrentMp());
    whitemage.setCurrentMp(whitemage.getMaxMp()/5);
    assertNotEquals("The CurrentMp is not the expected", whitemage.getMaxMp(), whitemage.getCurrentMp());
  }

  @Test
  public void setCurrentMpTest() throws InvalidStatValueException {
    whitemage.setCurrentMp(0);
    assertEquals("setCurrentMp is not working as intended", 0, whitemage.getCurrentMp());
    assertThrows(InvalidStatValueException.class, () -> whitemage.setCurrentMp(-1));
    assertThrows(InvalidStatValueException.class, () -> whitemage.setCurrentMp(whitemage.getMaxMp()+1));
    assertNotEquals("setCurrentMp should not be equals", whitemage.getMaxMp(), whitemage.getCurrentMp());
  }
}