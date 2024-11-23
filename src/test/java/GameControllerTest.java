import cl.uchile.dcc.finalreality.GameController;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
import cl.uchile.dcc.finalreality.game.states.*;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.*;
import cl.uchile.dcc.finalreality.model.magic.spell.Heal;
import cl.uchile.dcc.finalreality.model.magic.spell.Thunder;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameControllerTest {
  GameController gameController;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @Before
  public void setUp() throws InvalidStatValueException, InvalidWeaponTypeException {
    gameController = new GameController();
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @Test
  public void attackTest() throws InvalidStatValueException, InvalidWeaponTypeException, InterruptedException {
    Enemy enemy = new Enemy("EnemyTest", 10, 30, 10, 30, gameController.getTurnsQueue());
    Knight knight = new Knight("KnightTest", 30, 10,  gameController.getTurnsQueue());
    knight.equip(new Sword("SwordTest", 10, 30));
    enemy.subscribe(gameController);
    knight.subscribe(gameController);
    assertFalse("The enemy should not be in the turnsQueue",  gameController.getTurnsQueue().contains(enemy));
    assertFalse("The knight should not be in the turnsQueue",  gameController.getTurnsQueue().contains(knight));
    assertEquals("The enemy should have the same Hp that the knight", enemy.getCurrentHp(), knight.getCurrentHp());
    gameController.attack(knight, enemy);
    assertEquals("The enemy should have 10 Hp", 10, enemy.getCurrentHp());
    gameController.attack(enemy, knight);
    assertEquals("The knight should have 10 Hp", 10, knight.getCurrentHp());
    Thread.sleep(1100);
    assertTrue("The enemy should be in the turnsQueue",  gameController.getTurnsQueue().contains(enemy));
    assertTrue("The knight should be in the turnsQueue",  gameController.getTurnsQueue().contains(knight));
    gameController.attack(knight, enemy);
    assertFalse("The enemy should not be in the turnsQueue",  gameController.getTurnsQueue().contains(enemy));
    assertFalse("The enemy should not be in this queue",  gameController.getEnemies().contains(enemy));
    gameController.attack(knight, knight);
    assertFalse("The knight should not be in the turnsQueue",  gameController.getTurnsQueue().contains(knight));
    assertFalse("The knight should not be in this queue",  gameController.getPlayerCharacters().contains(knight));
  }

  @Test
  public void useMagicTest() throws InvalidStatValueException, InvalidWeaponTypeException, InterruptedException {
    WhiteMage whiteMage = new WhiteMage("WhiteMageTest", 30, 10, 20, gameController.getTurnsQueue());
    whiteMage.subscribe(gameController);
    BlackMage blackMage = new BlackMage("BlackMageTest", 30, 10, 100, gameController.getTurnsQueue());
    blackMage.subscribe(gameController);
    Staff staff = new Staff("StaffTest", 10, 30, 30);
    blackMage.equip(staff);
    whiteMage.equip(staff);
    whiteMage.equipSpell(new Heal());
    blackMage.equipSpell(new Thunder());
    assertFalse("The whiteMage should not be in the turnsQueue",  gameController.getTurnsQueue().contains(whiteMage));
    assertFalse("The blackMage should not be in the turnsQueue",  gameController.getTurnsQueue().contains(blackMage));
    assertEquals("The blackMage should have the same Hp that the whiteMage", whiteMage.getCurrentHp(), blackMage.getCurrentHp());
    assertEquals("The blackMage should have 100 mp", 100, blackMage.getCurrentMp());
    assertEquals("The whiteMage should have 20 mp", 20, whiteMage.getCurrentMp());
    gameController.useMagic(blackMage, whiteMage);
    assertEquals("The blackMage should have 85 mp", 85, blackMage.getCurrentMp());
    assertEquals("The whiteMage should have 10 Hp", 10, whiteMage.getCurrentHp());
    gameController.useMagic(whiteMage, whiteMage);
    assertEquals("The whiteMage should have 19 Hp", 19, whiteMage.getCurrentHp());
    assertEquals("The whiteMage should have 5 mp", 5, whiteMage.getCurrentMp());
    Thread.sleep(1100);
    assertTrue("The whiteMage should be in the turnsQueue",  gameController.getTurnsQueue().contains(whiteMage));
    assertTrue("The blackMage should be in the turnsQueue",  gameController.getTurnsQueue().contains(blackMage));
    blackMage.setCurrentHp(25);
    gameController.getTurnsQueue().remove(whiteMage);
    assertFalse("The whiteMage should not be in the turnsQueue",  gameController.getTurnsQueue().contains(whiteMage));
    gameController.useMagic(whiteMage, blackMage);
    Thread.sleep(1100);
    assertEquals("Not sufficient Mp, the Spell costs 15 Mp and the caster have 5", outputStreamCaptor.toString().trim());
    assertFalse("The whiteMage should not be in the turnsQueue",  gameController.getTurnsQueue().contains(whiteMage));
    gameController.useMagic(blackMage, whiteMage);
    assertFalse("The whiteMage should not be in the turnsQueue",  gameController.getTurnsQueue().contains(whiteMage));
    assertFalse("The whiteMage should not be in this queue",  gameController.getPlayerCharacters().contains(whiteMage));
    assertEquals("The whiteMage should have 0 Hp", 0, whiteMage.getCurrentHp());
  }

  @Test
  public void playerWinTest() {
    while (!(gameController.getEnemies().isEmpty())){
      assertFalse("The player did not jet win", gameController.playerWin());
      assertEquals("The game state should be in Idle", new Idle(), gameController.getCurrentState());
      gameController.getEnemies().remove(0);
    }
    assertTrue("The player should have won", gameController.playerWin());
    assertEquals("The game state should be in EndState", new EndState(), gameController.getCurrentState());
    assertEquals("The Player have won the battle!", outputStreamCaptor.toString().trim());
  }

  @Test
  public void enemyWinTest() {
    while (!(gameController.getPlayerCharacters().isEmpty())){
      assertFalse("The enemies did not jet win", gameController.enemyWin());
      assertEquals("The game state should be in Idle", new Idle(), gameController.getCurrentState());
      gameController.getPlayerCharacters().remove(0);
    }
    assertTrue("The enemies should have won", gameController.enemyWin());
    assertEquals("The game state should be in EndState", new EndState(), gameController.getCurrentState());
    assertEquals("The Enemies have won the battle :c", outputStreamCaptor.toString().trim());
  }

  @Test
  public void createThiefTest() throws InvalidStatValueException, InvalidWeaponTypeException, InterruptedException {
    gameController.createThief("Sram the Thief", 100, 40);
    Thread.sleep(1100);
    assertTrue("Sram the Thief should be in the queue", gameController.
        getTurnsQueue().contains(new Thief("Sram the Thief", 100,
            40, gameController.getTurnsQueue())));
    assertTrue("Sram the Thief should be in the queue", gameController.
        getPlayerCharacters().contains(new Thief("Sram the Thief", 100,
            40, gameController.getTurnsQueue())));
  }

  @Test
  public void createEngineerTest() throws InvalidStatValueException, InvalidWeaponTypeException, InterruptedException {
    gameController.createEngineer("Steamer the Engineer", 120, 30);
    Thread.sleep(1100);
    assertTrue("Steamer the Engineer should be in the queue", gameController.
        getTurnsQueue().contains(new Engineer("Steamer the Engineer", 120,
            30, gameController.getTurnsQueue())));
    assertTrue("Steamer the Engineer should be in the queue", gameController.
        getPlayerCharacters().contains(new Engineer("Steamer the Engineer", 120,
            30, gameController.getTurnsQueue())));
  }

  @Test
  public void createKnightTest() throws InvalidStatValueException, InvalidWeaponTypeException, InterruptedException {
    gameController.createKnight("Goultar the Knight", 5000, 300);
    Thread.sleep(2100);
    assertTrue("Goultar the Knight should be in the queue", gameController.
        getTurnsQueue().contains(new Knight("Goultar the Knight", 5000,
            300, gameController.getTurnsQueue())));
    assertTrue("Goultar the Knight should be in the queue", gameController.
        getPlayerCharacters().contains(new Knight("Goultar the Knight", 5000,
            300, gameController.getTurnsQueue())));
  }

  @Test
  public void createBlackMageTest() throws InvalidStatValueException, InvalidWeaponTypeException, InterruptedException {
    gameController.createBlackMage("Nox the BlackMage", 2000, 150, 200);
    Thread.sleep(1100);
    assertTrue("Nox the BlackMage should be in the queue", gameController.
        getTurnsQueue().contains(new BlackMage("Nox the BlackMage", 2000,
            150, 200, gameController.getTurnsQueue())));
    assertTrue("Nox the BlackMage should be in the queue", gameController.
        getPlayerCharacters().contains(new BlackMage("Nox the BlackMage", 2000,
            150, 200, gameController.getTurnsQueue())));
  }

  @Test
  public void createTWhiteMageTest() throws InvalidStatValueException, InvalidWeaponTypeException, InterruptedException {
    gameController.createWhiteMage("Yugo the WhiteMage", 1000, 60, 500);
    Thread.sleep(1100);
    assertTrue("Yugo the WhiteMage should be in the queue", gameController.
        getTurnsQueue().contains(new WhiteMage("Yugo the WhiteMage", 1000,
            60, 500, gameController.getTurnsQueue())));
    assertTrue("Yugo the WhiteMage should be in the queue", gameController.
        getPlayerCharacters().contains(new WhiteMage("Yugo the WhiteMage", 1000,
            60, 500, gameController.getTurnsQueue())));
  }

  @Test
  public void createEnemyTest() throws InvalidStatValueException, InterruptedException {
    gameController.createEnemy("Shigaraki", 6, 200, 400, 1000);
    Thread.sleep(2100);
    assertTrue("Shigaraki should be in the queue", gameController.
        getTurnsQueue().contains(new Enemy("Shigaraki", 6,
            200, 400, 1000, gameController.getTurnsQueue())));
    assertTrue("Shigaraki should be in the queue", gameController.
        getEnemies().contains(new Enemy("Shigaraki", 6,
            200, 400, 1000, gameController.getTurnsQueue())));
  }

  @Test
  public void getEnemiesTest() throws InvalidStatValueException {
    Enemy enemy = gameController.getEnemies().get(0);
    assertEquals("The first enemy in the queue is not the expected", new Enemy(
        "Comte Harebourg the Enemy", 20, 80, 0,
        30, gameController.getTurnsQueue()), enemy);
    assertNotEquals("The first enemy should not be equals to the second",
        enemy, gameController.getEnemies().get(1));
  }

  @Test
  public void getPlayerCharacterTest() throws InvalidStatValueException {
    PlayerCharacter playerCharacter = gameController.getPlayerCharacters().get(0);
    assertEquals("The first playerCharacter in the queue is not the expected", new Knight(
        "Goultar the Knight", 50, 10, gameController.getTurnsQueue()), playerCharacter);
    assertNotEquals("The first playerCharacter should not be equals to the second",
        playerCharacter, gameController.getPlayerCharacters().get(1));
  }

  @Test
  public void getTurnQueueTest() throws InvalidStatValueException, InterruptedException {
    PlayerCharacter playerCharacter = gameController.getPlayerCharacters().get(0);
    Thread.sleep(2100);
    Enemy enemy = gameController.getEnemies().get(0);
    assertTrue("The enemy should be in the queue", gameController.getTurnsQueue().contains(enemy));
    assertTrue("The playerCharacter should be in the queue", gameController.getTurnsQueue().contains(playerCharacter));
    assertFalse("The playerCharacter should not be in the queue", gameController.getTurnsQueue().contains(
        new Engineer("Test", 10, 10, gameController.getTurnsQueue())));
  }

  @Test
  public void getCurrentStateTest() throws InvalidStatValueException {
    assertEquals("The game state should be in Idle", new Idle(), gameController.getCurrentState());
    gameController.setCurrentState(new EndState());
    assertEquals("The game state should be in EndState", new EndState(), gameController.getCurrentState());
    gameController.setCurrentState(new PlayerCharacterTurn(new Engineer("Test", 10, 10, gameController.getTurnsQueue())));
    assertNotEquals("The game state should be in PlayerCharacterTurn", new EndState(), gameController.getCurrentState());
  }

  @Test
  public void setCurrentStateTest() throws InvalidStatValueException {
    GameState s = gameController.getCurrentState();
    assertEquals("The game state should be an Idle", new Idle(), s);
    assertEquals("The state should have the correct instance of GameController", gameController, s.getContext());
    assertNotEquals("The state should have different instance of GameController", gameController, new Idle().getContext());
    gameController.setCurrentState(new EndState());
    assertEquals("The game state should be in EndState", new EndState(), gameController.getCurrentState());
    gameController.setCurrentState(new PlayerCharacterTurn(new Engineer("Test", 10, 10, gameController.getTurnsQueue())));
    assertNotEquals("The game state should be in PlayerCharacterTurn", new EndState(), gameController.getCurrentState());
  }

  @Test
  public void updateDeathOfPlayerTest() throws InterruptedException {
    PlayerCharacter playerCharacter = gameController.getPlayerCharacters().get(0);
    Thread.sleep(2100);
    assertTrue("The playerCharacter should be in the queue", gameController.getTurnsQueue().contains(playerCharacter));
    assertTrue("The playerCharacter should be in the queue", gameController.getPlayerCharacters().contains(playerCharacter));
    gameController.updateDeathOfPlayerCharacter(playerCharacter);
    assertFalse("The playerCharacter should not be in the queue", gameController.getTurnsQueue().contains(playerCharacter));
    assertFalse("The playerCharacter should not be in the queue", gameController.getPlayerCharacters().contains(playerCharacter));
    while (!(gameController.getPlayerCharacters().isEmpty())) {
      assertEquals("The GameController should be in Idle State", new Idle(), gameController.getCurrentState());
      gameController.updateDeathOfPlayerCharacter(gameController.getPlayerCharacters().get(0));
    }
    assertEquals("The GameController should be in EndState", new EndState(), gameController.getCurrentState());
  }

  @Test
  public void updateDeathOfEnemyTest() throws InterruptedException {
    Enemy enemy = gameController.getEnemies().get(0);
    Thread.sleep(2100);
    assertTrue("The Enemy should be in the queue", gameController.getTurnsQueue().contains(enemy));
    assertTrue("The Enemy should be in the queue", gameController.getEnemies().contains(enemy));
    gameController.updateDeathOfEnemy(enemy);
    assertFalse("The Enemy should not be in the queue", gameController.getTurnsQueue().contains(enemy));
    assertFalse("The Enemy should not be in the queue", gameController.getEnemies().contains(enemy));
    while (!(gameController.getEnemies().isEmpty())) {
      assertEquals("The GameController should be in Idle State", new Idle(), gameController.getCurrentState());
      gameController.updateDeathOfEnemy(gameController.getEnemies().get(0));
    }
    assertEquals("The GameController should be in EndState", new EndState(), gameController.getCurrentState());
  }
}
