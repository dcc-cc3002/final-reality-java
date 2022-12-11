package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidStateTransitionException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.game.states.GameState;
import cl.uchile.dcc.finalreality.game.states.MageCharacterTurn;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.magic.spell.NullSpell;
import cl.uchile.dcc.finalreality.model.magic.spell.Spell;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all mages characters of the game.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Arturo Kullmer~
 */

public abstract class AbstractMageCharacter extends
    AbstractPlayerCharacter implements MageCharacter {

  private final int maxMp;
  private int currentMp;
  private Spell spell;

  /**
   * Creates a new MageCharacter character.
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
   * @param maxMp
   *     the character's max mp
   */

  protected AbstractMageCharacter(final @NotNull String name, final int maxHp, final int defense,
                                  final @NotNull BlockingQueue<GameCharacter> turnsQueue,
                                  final int maxMp)
                                  throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
    Require.statValueAtLeast(0, maxMp, "Max Mp");
    this.maxMp = maxMp;
    this.currentMp = maxMp;
    this.spell = new NullSpell();
  }

  /**
   * Returns the max MP of the character.
   */
  public int getMaxMp() {
    return maxMp;
  }

  /**
   * Returns the current MP of the character.
   */
  public int getCurrentMp() {
    return currentMp;
  }

  /**
   * Sets the current MP of the character to {@code newMp}.
   */
  public void setCurrentMp(final int newMp) throws InvalidStatValueException {
    Require.statValueAtLeast(0, newMp, "Current Mp");
    Require.statValueAtMost(maxMp, newMp, "Current Mp");
    this.currentMp = newMp;
  }

  @Override
  public Spell getEquippedSpell() {
    return spell;
  }

  @Override
  public void equipSpell(Spell s) {
    this.spell = s;
  }

  @Override
  public void beginTurn(GameState s) throws InvalidStatValueException,
      InvalidStateTransitionException, InterruptedException {
    if (s.getContext().getPlayerCharacters().contains(this)) {
      s.changeState(new MageCharacterTurn(this));
      this.getAdverseEffect().applyEffect(this, s);
    }
    else {
      s.nextTurn();
    }
  }
}
