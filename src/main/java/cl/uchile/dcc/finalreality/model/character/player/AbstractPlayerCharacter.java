/*
 * "Final Reality" (c) by R8V and ~Arturo Kullmer~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player;

import static cl.uchile.dcc.finalreality.exceptions.Require.equippedWeaponNull;

import cl.uchile.dcc.finalreality.Subscriber;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidStateTransitionException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
import cl.uchile.dcc.finalreality.game.states.EnemyTurn;
import cl.uchile.dcc.finalreality.game.states.GameState;
import cl.uchile.dcc.finalreality.game.states.PlayerCharacterTurn;
import cl.uchile.dcc.finalreality.model.character.AbstractCharacter;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a player-controlled character in the game.
 *
 * <p>All player characters have a {@code name}, a maximum amount of <i>hit points</i>
 * ({@code maxHp}), a {@code defense} value, a queue of {@link GameCharacter}s that are
 * waiting for their turn ({@code turnsQueue}), and can equip a {@link Weapon}.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Arturo Kullmer~
 */
public abstract class AbstractPlayerCharacter extends AbstractCharacter implements
    PlayerCharacter {

  protected Weapon equippedWeapon = null;

  /**
   * Creates a new character.
   * This constructor is <b>protected</b>, because it'll only be used by subclasses.
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
  protected AbstractPlayerCharacter(@NotNull final String name, final int maxHp,
      final int defense, @NotNull final BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
  }

  public abstract void equip(Weapon weapon) throws InvalidWeaponTypeException;

  @Override
  public void notifySubscribersDeath() {
    for (Subscriber s : this.getSubscribers()) {
      s.updateDeathOfPlayerCharacter(this);
    }
  }

  @Override
  public Weapon getEquippedWeapon() {
    return equippedWeapon;
  }

  public int getWeight() throws InvalidStatValueException {
    equippedWeaponNull(getEquippedWeapon());
    return getEquippedWeapon().getWeight();
  }

  public int getAttack() throws InvalidStatValueException {
    equippedWeaponNull(getEquippedWeapon());
    return getEquippedWeapon().getDamage();
  }

  @Override
  public void beginTurn(GameState s) throws InvalidStatValueException,
      InvalidStateTransitionException, InterruptedException {
    if (s.getContext().getPlayerCharacters().contains(this)) {
      s.changeState(new PlayerCharacterTurn(this));
      this.getAdverseEffect().applyEffect(this, s);
    } else {
      s.nextTurn();
    }
  }
}
