package cl.uchile.dcc.finalreality;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
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
import cl.uchile.dcc.finalreality.model.magic.spell.Spell;
import cl.uchile.dcc.finalreality.model.magic.spell.Thunder;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.jetbrains.annotations.NotNull;

public class GameController implements Subscriber {
  private BlockingQueue<GameCharacter> turnsQueue = new LinkedBlockingQueue<>();
  private ArrayList<PlayerCharacter> playerCharacters = new ArrayList<>();
  private ArrayList<Enemy> enemies = new ArrayList<>();

  public GameController() throws InvalidStatValueException, InvalidWeaponTypeException {
    createKnight("Goultar the Knight", 50, 10);
    createEngineer("Goultar the Knight", 50, 8);
    createWhiteMage("Yugo the WhiteMage", 60, 8, 100);
    createThief("Sram the Thief", 40, 30);
    createEnemy("Comte Harebourg the Enemy", 20, 80, 0, 30);
    createEnemy("Arturo", 10, 60, 10, 20);
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
  public void useMagic(@NotNull MageCharacter attacker, @NotNull GameCharacter target)
      throws InvalidStatValueException {
    Spell magicSpell = attacker.getEquippedSpell();
    magicSpell.apply(attacker, target);
    waitTurn(attacker);
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
  public void onPlayerWin() {

  }

  /**
   * Handle the enemy winning the fight.
   */
  public void onEnemyWin() {

  }

  /**
   * Creates a new Knight with the specified parameters.
   */
  public void createKnight(String name, int hp, int defense)
      throws InvalidStatValueException, InvalidWeaponTypeException {
    Knight k = new Knight(name, hp, defense, turnsQueue);
    k.equip(new Sword("Smiling Sword", 20, 40));
    turnsQueue.add(k);
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
    turnsQueue.add(e);
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
    turnsQueue.add(t);
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
    turnsQueue.add(b);
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
    turnsQueue.add(whitemage);
    playerCharacters.add(whitemage);
    whitemage.subscribe(this);
  }

  /**
   * Creates a new Enemy with the specified parameters.
   */
  public void createEnemy(String name, int weight, int hp, int defense, int attack)
      throws InvalidStatValueException {
    Enemy e =  new Enemy(name, weight, hp, defense, attack, turnsQueue);
    turnsQueue.add(e);
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

  @Override
  public void updateDeathOfPlayerCharacter(GameCharacter c) {
    turnsQueue.remove(c);
    playerCharacters.remove(c);
  }

  @Override
  public void updateDeathOfEnemy(GameCharacter c) {
    turnsQueue.remove(c);
    enemies.remove(c);
  }
}
