/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.interfaces.EquippableByWhiteMage;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A white mage is a {@link PlayerCharacter} and also a {@link MageCharacter} that
 * can equip {@code Staff}s and use <i>white magic</i>.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Arturo Kullmer~
 */
public class WhiteMage extends AbstractMageCharacter {

  /**
   * Creates a new character.
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
  public WhiteMage(final @NotNull String name, final int maxHp, final int defense,
                      int maxMp, final @NotNull BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue, maxMp);
  }

  public void equip(EquippableByWhiteMage weapon) {
    weapon.equipToWhiteMage(this);
  }
  
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final WhiteMage that)) {
      return false;
    }
    return hashCode() == that.hashCode()
        && this.getMaxMp() == that.getMaxMp()
        && this.getCurrentMp() == that.getCurrentMp()
        && this.getName().equals(that.getName())
        && this.getMaxHp() == that.getMaxHp()
        && this.getCurrentHp() == that.getCurrentHp()
        && this.getDefense() == that.getDefense();
  }

  @Override
  public int hashCode() {
    return Objects.hash(WhiteMage.class, this.getName(), this.getMaxHp(),
        this.getCurrentHp(), this.getDefense(), this.getMaxMp());
  }

  @Override
  public String toString() {
    return "WhiteMage{currentMP=%d, maxMp=%d, maxHp=%d, currentHp=%d, defense=%d, name='%s'}"
        .formatted(this.getCurrentMp(), this.getMaxMp(), this.getMaxHp(),
            this.getCurrentHp(), this.getDefense(), this.getName());
  }
}
