package cl.uchile.dcc.finalreality.model;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.*;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class GameController implements Subscriber {
  private BlockingQueue<GameCharacter> turnsQueue;
  private ArrayList<PlayerCharacter> playerCharacters;
  private ArrayList<Enemy> enemies;
  private ArrayList<GameCharacter> paralyzedList;
  private ArrayList<GameCharacter> poisonList;
  private ArrayList<GameCharacter> burnedList;

  public GameController() {
    /**
     * init {
     *     for (i in 1..10) {
     *         // TODO: Add enemies to the game
     *         // TODO: Add players to the game
     *         // TODO: Add characters to the turns queue
     *     }
     * }
     */
  }

  /**
   * The recivied GameCharacter {@code attacker} attacks the GameCharacter {@code target}.
   */
  public void attack(GameCharacter attacker, GameCharacter target) {

  }

  /**
   * The recivied GameCharacter {@code attacker} uses a Spell on the GameCharacter {@code target}.
   */
  public void useMagic(GameCharacter attacker, GameCharacter target) {

  }

  /**
   * Call the waitTurn method of a GameCharacter.
   */
  public void waitTurn(GameCharacter c) throws InvalidStatValueException {
    c.waitTurn();
  }

  /**
   * Handle the player winning the fight.
   */
  public void onPlayerWin() {

  }

  /**
   * Handle the enemy winning the fight.
   */
  public void onEnemyWin() {

  }

  /**
   * Add the recivied GameCharacter to the list of paralyzed Characters
   */
  public void addParalyzed(GameCharacter c) {
    paralyzedList.add(c);
  }

  /**
   * Add the recivied GameCharacter to the list of poisoned Characters
   */
  public void addPoison(GameCharacter c) {
    poisonList.add(c);
  }

  /**
   * Add the recivied GameCharacter to the list of burned Characters
   */
  public void addBurned(GameCharacter c) {
    burnedList.add(c);
  }

  /**
   * Creates a new Knight with the specified parameters.
   */
  public Knight createKnight(String name, int hp, int defense, Weapon w)
      throws InvalidStatValueException, InvalidWeaponTypeException {
    Knight k = new Knight(name, hp, defense, turnsQueue);
    k.equip(w);
    return k;
  }

  /**
   * Creates a new Engineer with the specified parameters.
   */
  public Engineer createEngineer(String name, int hp, int defense, Weapon w)
      throws InvalidStatValueException, InvalidWeaponTypeException {
    Engineer e = new Engineer(name, hp, defense, turnsQueue);
    e.equip(w);
    return e;
  }

  /**
   * Creates a new Thief with the specified parameters.
   */
  public Thief createThief(String name, int hp, int defense, Weapon w)
      throws InvalidStatValueException, InvalidWeaponTypeException {
    Thief t = new Thief(name, hp, defense, turnsQueue);
    t.equip(w);
    return t;
  }

  /**
   * Creates a new BlackMage with the specified parameters.
   */
  public BlackMage createBlackMage(String name, int hp, int defense, int mp, Weapon w)
      throws InvalidStatValueException, InvalidWeaponTypeException {
    BlackMage b = new BlackMage(name, hp, defense, mp, turnsQueue);
    b.equip(w);
    return b;
  }

  /**
   * Creates a new WhiteMage with the specified parameters.
   */
  public WhiteMage createWhiteMage(String name, int hp, int defense, int mp, Weapon w)
      throws InvalidStatValueException, InvalidWeaponTypeException {
    WhiteMage whitemage = new WhiteMage(name, hp, defense, mp, turnsQueue);
    whitemage.equip(w);
    return whitemage;
  }

  /**
   * Creates a new Enemy with the specified parameters.
   */
  public Enemy createEnemy(String name, int weight, int hp, int defense, int attack)
      throws InvalidStatValueException {
    return new Enemy(name, weight, hp, defense, attack, turnsQueue);
  }

  @Override
  public void update() {
CUIDADOCORREGIR
  }
}
