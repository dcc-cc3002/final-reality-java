package cl.uchile.dcc.finalreality.game.states;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.util.Objects;
import java.util.Random;

/**
 * This class represents the turn of an Enemy.
 * In this turn an enemy can only attack other GameCharacter.
 * Attacking ends this turn.
 */
public class EnemyTurn extends AbstractGameState {
  private Enemy enemy;
  private Random random;

  public EnemyTurn(Enemy enemy) {
    this.enemy = enemy;
    this.random = new Random();
  }

  /**
   * This method selects automatically a random alive PlayerCharacter and attacks it.
   */
  public void autoAttack() throws InvalidStatValueException {
    int indexTarget = random.nextInt(this.getContext().getPlayerCharacters().size());
    attack(this.getContext().getPlayerCharacters().get(indexTarget));
  }

  @Override
  public void attack(GameCharacter target) throws InvalidStatValueException {
    changeState(new Idle());
    context.attack(enemy, target);
  }

  /**
   * Getter for the random value for testing.
   */
  public Random getRandom() {
    return random;
  }

  /**
   * Setter for the random value for testing.
   */
  public void setRandom(Random random) {
    this.random = random;
  }

  /**
   * Getter for the current enemy playing his turn.
   */
  public Enemy getEnemy() {
    return enemy;
  }

  @Override
  public int hashCode() {
    return Objects.hash(EnemyTurn.class, this.enemy);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final EnemyTurn that)) {
      return false;
    }
    return hashCode() == that.hashCode()
        && enemy == that.getEnemy();
  }
}
