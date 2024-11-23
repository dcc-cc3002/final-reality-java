package cl.uchile.dcc.finalreality;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
import cl.uchile.dcc.finalreality.game.states.EndState;
import cl.uchile.dcc.finalreality.game.states.EnemyTurn;
import cl.uchile.dcc.finalreality.game.states.GameState;
import cl.uchile.dcc.finalreality.game.states.Idle;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.magic.spell.Heal;
import cl.uchile.dcc.finalreality.model.magic.spell.Thunder;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * This class represents the controller of a battle in the game. It has states depending on
 * the turns of the characters and also haves a list of alive PlayerCharacter, another list
 * of alive enemies and a queue to make the turns work.
 */
public class GameController implements Subscriber {
  private BlockingQueue<GameCharacter> turnsQueue = new LinkedBlockingQueue<>();
  private ArrayList<PlayerCharacter> playerCharacters = new ArrayList<>();
  private ArrayList<Enemy> enemies = new ArrayList<>();
  private GameState currentState;

  /**
   * This constructor will create default characters to do a battle, this can change
   * in the future.
   */
  public GameController() throws InvalidStatValueException, InvalidWeaponTypeException {
    createKnight("Goultar the Knight", 50, 10);
    createEngineer("Goultar the Knight", 50, 8);
    createWhiteMage("Yugo the WhiteMage", 60, 8, 100);
    createThief("Sram the Thief", 40, 30);
    createEnemy("Comte Harebourg the Enemy", 20, 80, 0, 30);
    createEnemy("Arturo", 10, 60, 10, 20);
    this.setCurrentState(new Idle());
  }

  /**
   * The recivied GameCharacter {@code attacker} attacks the GameCharacter {@code target}.
   */
  public void attack(@NotNull GameCharacter attacker, @NotNull GameCharacter target)
      throws InvalidStatValueException {
    try {
      int attackVal = target.getAttack();
      int defenseVal = target.getDefense();
      if (defenseVal < attackVal) {
        target.setCurrentHp(target.getCurrentHp() - (attackVal - defenseVal));
      }
    } catch (InvalidStatValueException e) {
      target.setCurrentHp(0);
      target.notifySubscribersDeath();
    } finally {
      waitTurn(attacker);
    }
  }

  /**
   * The recivied GameCharacter {@code attacker} uses a Spell on the GameCharacter {@code target}.
   */
  public void useMagic(@NotNull MageCharacter attacker, @NotNull GameCharacter target) {
    try {
      attacker.getEquippedSpell().apply(attacker, target);
      waitTurn(attacker);
    } catch (InvalidStatValueException e) {
      System.out.println("Not sufficient Mp, the Spell costs "
          + attacker.getEquippedSpell().getCost() + " Mp and the caster have "
          + attacker.getCurrentMp());
    }
  }

  /**
   * Call the waitTurn method of a GameCharacter.
   */
  public void waitTurn(@NotNull GameCharacter c) throws InvalidStatValueException {
    c.waitTurn();
  }

  /**
   * Handle the player winning the fight.
   */
  public boolean playerWin() {
    if (enemies.isEmpty()) {
      setCurrentState(new EndState());
      System.out.println("The Player have won the battle!");
    }
    return enemies.isEmpty();
  }

  /**
   * Handle the enemy winning the fight.
   */
  public boolean enemyWin() {
    if (playerCharacters.isEmpty()) {
      setCurrentState(new EndState());
      System.out.println("The Enemies have won the battle :c");
    }
    return playerCharacters.isEmpty();
  }

  /**
   * Creates a new Knight with the specified parameters.
   */
  public void createKnight(String name, int hp, int defense)
      throws InvalidStatValueException, InvalidWeaponTypeException {
    Knight k = new Knight(name, hp, defense, turnsQueue);
    k.equip(new Sword("Smiling Sword", 20, 40));
    waitTurn(k);
    playerCharacters.add(k);
    k.subscribe(this);
  }

  /**
   * Creates a new Engineer with the specified parameters.
   */
  public void createEngineer(String name, int hp, int defense)
      throws InvalidStatValueException, InvalidWeaponTypeException {
    Engineer e = new Engineer(name, hp, defense, turnsQueue);
    e.equip(new Axe("Cil's Axe", 10, 30));
    waitTurn(e);
    playerCharacters.add(e);
    e.subscribe(this);
  }

  /**
   * Creates a new Thief with the specified parameters.
   */
  public void createThief(String name, int hp, int defense)
      throws InvalidStatValueException, InvalidWeaponTypeException {
    Thief t = new Thief(name, hp, defense, turnsQueue);
    t.equip(new Knife("Zeyko's Dagger's", 5, 25));
    waitTurn(t);
    playerCharacters.add(t);
    t.subscribe(this);
  }

  /**
   * Creates a new BlackMage with the specified parameters.
   */
  public void createBlackMage(String name, int hp, int defense, int mp)
      throws InvalidStatValueException, InvalidWeaponTypeException {
    BlackMage b = new BlackMage(name, hp, defense, mp, turnsQueue);
    b.equip(new Staff("Romboton", 10, 5, 60));
    b.equipSpell(new Thunder());
    waitTurn(b);
    playerCharacters.add(b);
    b.subscribe(this);
  }

  /**
   * Creates a new WhiteMage with the specified parameters.
   */
  public void createWhiteMage(String name, int hp, int defense, int mp)
      throws InvalidStatValueException, InvalidWeaponTypeException {
    WhiteMage whitemage = new WhiteMage(name, hp, defense, mp, turnsQueue);
    whitemage.equip(new Staff("Romboton", 10, 5, 60));
    whitemage.equipSpell(new Heal());
    waitTurn(whitemage);
    playerCharacters.add(whitemage);
    whitemage.subscribe(this);
  }

  /**
   * Creates a new Enemy with the specified parameters.
   */
  public void createEnemy(String name, int weight, int hp, int defense, int attack)
      throws InvalidStatValueException {
    Enemy e =  new Enemy(name, weight, hp, defense, attack, turnsQueue);
    waitTurn(e);
    enemies.add(e);
    e.subscribe(this);
  }

  /**
   * Getter for the turnsQueue.
   */
  public BlockingQueue<GameCharacter> getTurnsQueue() {
    return turnsQueue;
  }

  /**
   * Getter for the list of alive playerCharacters.
   */
  public ArrayList<PlayerCharacter> getPlayerCharacters() {
    return playerCharacters;
  }

  /**
   * Getter for the alive enemies.
   */
  public ArrayList<Enemy> getEnemies() {
    return enemies;
  }

  /**
   * Getter for the currentState.
   */
  public GameState getCurrentState() {
    return currentState;
  }

  /**
   * Setter for the currentState, it also changes the context of the recived State.
   */
  public void setCurrentState(@NotNull GameState currentState) {
    this.currentState = currentState;
    currentState.setContext(this);
  }

  @Override
  public void updateDeathOfPlayerCharacter(GameCharacter c) {
    turnsQueue.remove(c);
    playerCharacters.remove(c);
    enemyWin();
  }

  @Override
  public void updateDeathOfEnemy(GameCharacter c) {
    turnsQueue.remove(c);
    enemies.remove(c);
    playerWin();
  }
}
