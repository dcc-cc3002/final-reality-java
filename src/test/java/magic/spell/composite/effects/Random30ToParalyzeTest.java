package magic.spell.composite.effects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.adverse.effects.NullAdverseEffect;
import cl.uchile.dcc.finalreality.model.adverse.effects.ParalyzeAdverseEffect;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.Effect;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.NullEffect;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.Random30ToParalyze;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Random30ToParalyzeTest {
  WhiteMage whiteMage;
  Random30ToParalyze self;
  Effect self2;
  Effect self3;
  int seed;
  Random rng;

  @Before
  public void setUp() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    whiteMage = new WhiteMage("TestKnight", 30, 10, 100, queue);
    self = new Random30ToParalyze();
    self2 = new Random30ToParalyze();
    self3 = new NullEffect();
    seed = 128342;
    rng = new Random(seed);
  }
  @Test
  public void applyTest() throws InvalidStatValueException {
    assertEquals("The AdverseEffect is not the expected", new NullAdverseEffect(), whiteMage.getAdverseEffect());
    self.setRandom(rng);
    self.apply(whiteMage, whiteMage);
    assertEquals("The AdverseEffect is not the expected", new NullAdverseEffect(), whiteMage.getAdverseEffect());
    self.apply(whiteMage, whiteMage);
    assertEquals("The AdverseEffect is not the expected", new NullAdverseEffect(), whiteMage.getAdverseEffect());
    self.apply(whiteMage, whiteMage);
    assertEquals("The AdverseEffect is not the expected", new NullAdverseEffect(), whiteMage.getAdverseEffect());
    self.apply(whiteMage, whiteMage);
    assertEquals("The AdverseEffect is not the expected", new NullAdverseEffect(), whiteMage.getAdverseEffect());
    self.apply(whiteMage, whiteMage);
    assertEquals("The AdverseEffect is not the expected", new ParalyzeAdverseEffect(), whiteMage.getAdverseEffect());
  }

  @Test
  public void setGetRandomTest() {
    self.setRandom(rng);
    assertEquals(new Random(128342).nextDouble(), self.getRandom().nextDouble(), 0.001);
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
