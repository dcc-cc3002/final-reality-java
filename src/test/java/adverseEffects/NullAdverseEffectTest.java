package adverseEffects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.adverseEffects.AdverseEffect;
import cl.uchile.dcc.finalreality.model.adverseEffects.NullAdverseEffect;
import cl.uchile.dcc.finalreality.model.adverseEffects.ParalyzeAdverseEffect;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class NullAdverseEffectTest {
  WhiteMage whiteMage;
  AdverseEffect self;
  AdverseEffect self2;
  AdverseEffect self3;

  @Before
  public void setUp() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    whiteMage = new WhiteMage("TestChar", 30, 10, 100, queue);
    self = new NullAdverseEffect();
    self2 = new NullAdverseEffect();
    self3 = new ParalyzeAdverseEffect();
  }

  @Test
  public void applyEffectTest() throws InvalidStatValueException {
    assertEquals("The Hp should be 30", 30, whiteMage.getCurrentHp());
    self.applyEffect(whiteMage);
  }

  @Test
  public void testEquals() {
    assertEquals("A NullAdverseEffect is not equals to itself", true, self.equals(self));
    assertEquals("A NullAdverseEffect is not equals to another NullAdverseEffect with same parameters",
        true, self.equals(self2));
    assertEquals("A NullAdverseEffect is the same as a ParalyzeAdverseEffect", false, self.equals(self3));
  }

  @Test
  public void testHashCode() {
    assertEquals("Two equals NullAdverseEffects does not have the same hashCode",
        self.hashCode(), self2.hashCode());
    assertNotEquals("Two different NullAdverseEffects have the same Hashcode", self.hashCode(), self3.hashCode());
  }
}
