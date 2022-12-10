package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.Subscriber;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.game.states.EnemyTurn;
import cl.uchile.dcc.finalreality.game.states.GameState;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Arturo Kullmer~
 */
public class Enemy extends AbstractCharacter {

  private final int weight;
  private final int attack;

  /**
   * Creates a new enemy with a name, a weight and the queue with the characters ready to
   * play.
   */
  public Enemy(@NotNull final String name, final int weight, int maxHp, int defense,
               final int attack, @NotNull final BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
    Require.statValueAtLeast(1, weight, "Weight");
    this.weight = weight;
    this.attack = attack;
  }

  @Override
  public void notifySubscribersDeath() {
    for (Subscriber s : this.getSubscribers()) {
      s.updateDeathOfEnemy(this);
    }
  }

  /**
   * Returns the weight of this enemy.
   */
  public int getWeight() {
    return weight;
  }

  /**
   * Returns the attack of this enemy.
   */
  public int getAttack() {
    return attack;
  }

  @Override
  public void beginTurn(GameState s) {
    s.changeState(new EnemyTurn(this));
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Enemy enemy)) {
      return false;
    }
    return hashCode() == enemy.hashCode()
        && this.getName().equals(enemy.getName())
        && weight == enemy.weight
        && this.getMaxHp() == enemy.getMaxHp()
        && this.getDefense() == enemy.getDefense()
        && attack == enemy.attack
        && this.getCurrentHp() == enemy.getCurrentHp();
  }

  @Override
  public int hashCode() {
    return Objects.hash(Enemy.class, this.getName(), weight, this.getMaxHp(),
        this.getDefense(), attack, this.getCurrentHp());
  }

  @Override
  public String toString() {
    return "Enemy{maxHp=%d, currentHp=%d, defense=%d, name='%s', weight=%d, attack=%d}"
           .formatted(this.getMaxHp(), this.getCurrentHp(), this.getDefense(),
               this.getName(), weight, attack);
  }
}
