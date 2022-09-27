package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.BlockingQueue;

/**
 * An abstract class that holds the common behaviour of all mages of the game.
 */

public abstract class AbstractMage extends AbstractPlayerCharacter implements Mage{

  private final int maxMP;
  private int currentMP;

  /**
   * Creates a new Mage character
   * @param name
   *     the character's name
   * @param maxHp
   *     the character's max hp
   * @param defense
   *     the character's defense
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   * @param maxMP
   *     the character's max mp
   */

  public AbstractMage(final @NotNull String name, final int maxHp, final int defense,
                      final @NotNull BlockingQueue<GameCharacter> turnsQueue, final int maxMP) throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
    Require.statValueAtLeast(0, maxMP, "Max MP");
    this.maxMP = maxMP;
    this.currentMP = maxMP;
  }

  /**
   * Returns the max MP of the character.
   */
  public int getMaxMp() {
    return maxMP;
  }

  /**
   * Returns the current MP of the character.
   */
  public int getCurrentMp() {
    return currentMP;
  }

  /**
   * Sets the current MP of the character to {@code newMp}.
   */
  public void setCurrentMp(final int newMp) throws InvalidStatValueException {
    Require.statValueAtLeast(0, newMp, "Current MP");
    Require.statValueAtMost(maxMP, newMp, "Current MP");
    this.currentMP = newMp;
  }
}
