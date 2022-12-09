package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.Subscriber;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.adverse.effects.AdverseEffect;
import cl.uchile.dcc.finalreality.model.adverse.effects.NullAdverseEffect;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Arturo Kullmer~
 */
public abstract class AbstractCharacter implements GameCharacter {

  private int currentHp;
  private final int maxHp;
  private final int defense;
  protected final BlockingQueue<GameCharacter> turnsQueue;
  private final String name;
  private ScheduledExecutorService scheduledExecutor;
  private ArrayList<Subscriber> subscribers = new ArrayList<>();
  private AdverseEffect adverseEffect;

  /**
   * Creates a new character.
   * Constructor is <b>protected</b> because it is only used by subclases,
   * and it will be not instanciated.
   *
   * @param name
   *     the character's name
   * @param maxHp
   *     the character's max hp
   * @param defense
   *     the character's defense
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   */
  protected AbstractCharacter(@NotNull String name, int maxHp, int defense,
      @NotNull BlockingQueue<GameCharacter> turnsQueue) throws InvalidStatValueException {
    Require.statValueAtLeast(1, maxHp, "Max HP");
    Require.statValueAtLeast(0, defense, "Defense");
    this.maxHp = maxHp;
    this.currentHp = maxHp;
    this.defense = defense;
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.adverseEffect = new NullAdverseEffect();
  }

  @Override
  public void waitTurn() throws InvalidStatValueException {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor.schedule(
          /* command = */ this::addToQueue,
          /* delay = */ this.getWeight() / 10,
          /* unit = */ TimeUnit.SECONDS);
  }

  /**
   * Adds this character to the turns queue.
   */
  private void addToQueue() {
    try {
      turnsQueue.put(this);
    } catch (Exception e) {
      e.printStackTrace();
    }
    scheduledExecutor.shutdown();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getCurrentHp() {
    return currentHp;
  }

  @Override
  public int getMaxHp() {
    return maxHp;
  }

  @Override
  public int getDefense() {
    return defense;
  }

  @Override
  public void setCurrentHp(int hp) throws InvalidStatValueException {
    Require.statValueAtLeast(0, hp, "Current HP");
    Require.statValueAtMost(maxHp, hp, "Current HP");
    currentHp = hp;
  }

  @Override
  public void subscribe(Subscriber s) {
    subscribers.add(s);
  }

  @Override
  public ArrayList<Subscriber> getSubscribers() {
    return subscribers;
  }

  @Override
  public void setAdverseEffect(AdverseEffect ae) {
    this.adverseEffect = ae;
  }

  @Override
  public AdverseEffect getAdverseEffect() {
    return adverseEffect;
  }

  public abstract void notifySubscribersDeath();

  /**
   * The responsability of the implementation of getWeight method will be passed to the subclasses.
   */
  public abstract int getWeight() throws InvalidStatValueException;

  /**
   * The responsability of the implementation of getAttack method will be passed to the subclasses.
   */
  public abstract int getAttack() throws InvalidStatValueException;
}
