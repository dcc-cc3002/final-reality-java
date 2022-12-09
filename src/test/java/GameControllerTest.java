import cl.uchile.dcc.finalreality.GameController;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameControllerTest {
  GameController gameController;

  @Before
  public void setUp() throws InvalidStatValueException, InvalidWeaponTypeException {
    gameController = new GameController();
  }

  @Test
  public void createPlayerAndEnemy() throws InvalidStatValueException, InvalidWeaponTypeException {
    gameController.createThief("Sram the Thief", 100, 40);
    assertTrue("Sram the Thief should be in the queue", gameController.
        getTurnsQueue().contains(new Thief("Sram the Thief", 100,
            40, gameController.getTurnsQueue())));
    assertTrue("Sram the Thief should be in the queue", gameController.
        getPlayerCharacters().contains(new Thief("Sram the Thief", 100,
            40, gameController.getTurnsQueue())));

    gameController.createEngineer("Steamer the Engineer", 120, 30);
    assertTrue("Steamer the Engineer should be in the queue", gameController.
        getTurnsQueue().contains(new Engineer("Steamer the Engineer", 120,
            30, gameController.getTurnsQueue())));
    assertTrue("Steamer the Engineer should be in the queue", gameController.
        getPlayerCharacters().contains(new Engineer("Steamer the Engineer", 120,
            30, gameController.getTurnsQueue())));

    gameController.createKnight("Goultar the Knight", 5000, 300);
    assertTrue("Goultar the Knight should be in the queue", gameController.
        getTurnsQueue().contains(new Knight("Goultar the Knight", 5000,
            300, gameController.getTurnsQueue())));
    assertTrue("Goultar the Knight should be in the queue", gameController.
        getPlayerCharacters().contains(new Knight("Goultar the Knight", 5000,
            300, gameController.getTurnsQueue())));

    gameController.createBlackMage("Nox the BlackMage", 2000, 150, 200);
    assertTrue("Nox the BlackMage should be in the queue", gameController.
        getTurnsQueue().contains(new BlackMage("Nox the BlackMage", 2000,
            150, 200, gameController.getTurnsQueue())));
    assertTrue("Nox the BlackMage should be in the queue", gameController.
        getPlayerCharacters().contains(new BlackMage("Nox the BlackMage", 2000,
            150, 200, gameController.getTurnsQueue())));

    gameController.createWhiteMage("Yugo the WhiteMage", 1000, 60, 500);
    assertTrue("Yugo the WhiteMage should be in the queue", gameController.
        getTurnsQueue().contains(new WhiteMage("Yugo the WhiteMage", 1000,
            60, 500, gameController.getTurnsQueue())));
    assertTrue("Yugo the WhiteMage should be in the queue", gameController.
        getPlayerCharacters().contains(new WhiteMage("Yugo the WhiteMage", 1000,
            60, 500, gameController.getTurnsQueue())));

    gameController.createEnemy("Shigaraki", 6, 200, 400, 1000);
    assertTrue("Shigaraki should be in the queue", gameController.
        getTurnsQueue().contains(new Enemy("Shigaraki", 6,
            200, 400, 1000, gameController.getTurnsQueue())));
    assertTrue("Shigaraki should be in the queue", gameController.
        getEnemies().contains(new Enemy("Shigaraki", 6,
            200, 400, 1000, gameController.getTurnsQueue())));
  }
}
