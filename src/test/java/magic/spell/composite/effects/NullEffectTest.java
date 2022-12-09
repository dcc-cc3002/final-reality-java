package magic.spell.composite.effects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.Effect;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.Heal30Effect;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.NullEffect;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class NullEffectTest {
  WhiteMage whiteMage;
  Effect self;
  Effect self2;
  Effect self3;
  @Before
  public void setUp() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    whiteMage = new WhiteMage("TestKnight", 30, 10, 100, queue);
    self = new NullEffect();
    self2 = new NullEffect();
    self3 = new Heal30Effect();
  }
  @Test
  public void applyTest() throws InvalidStatValueException {
    whiteMage.setCurrentHp(21);
    assertEquals("The Hp should be 21", 21, whiteMage.getCurrentHp());
    self.apply(whiteMage, whiteMage);
    assertEquals("The Hp should be 21", 21, whiteMage.getCurrentHp());
  }

  @Test
  public void testEquals() {
    assertEquals("A Knight is not equals to itself", true, self.equals(self));
    assertEquals("A Knight is not equals to another Knight with same parameters",
        true, self.equals(self2));
    assertEquals("A Knight is the same as a WhiteMage", false, self.equals(self3));
  }

  @Test
  public void testHashCode() {
    assertEquals("Two equals Knights does not have the same hashCode",
        self.hashCode(), self2.hashCode());
    assertNotEquals("Two different Knights have the same Hashcode", self.hashCode(), self3.hashCode());
  }
}