package model.magic.spell.composite.effects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.adverse.effects.NullAdverseEffect;
import cl.uchile.dcc.finalreality.model.adverse.effects.ParalyzeAdverseEffect;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.*;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class RandomCompositeTest {
  WhiteMage whiteMage;
  RandomComposite self;
  RandomComposite self2;
  Effect self3;
  Effect[] effects = new Effect[1];
  Effect[] effects2 = new Effect[1];
  Effect[] effects3 = new Effect[2];
  int seed;
  Random rng;

  @Before
  public void setUp() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    whiteMage = new WhiteMage("TestKnight", 30, 10, 100, queue);
    effects[0] = new ParalyzeEffect();
    effects2[0] = new ParalyzeEffect();
    self = new RandomComposite(effects, 0.3);
    self2 = new RandomComposite(effects2, 0.3);
    effects3[0] = new NullEffect();
    effects3[1] = new BurnEffect();
    self3 = new CompositeEffect(effects3);
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
    assertEquals("A RandomComposite is not equals to itself", true, self.equals(self));
    assertEquals("A RandomComposite is not equals to another RandomComposite with same parameters",
        true, self.equals(self2));
    assertEquals("A RandomComposite is the same as a CompositeEffect", false, self.equals(self3));
  }

  @Test
  public void testHashCode() {
    assertEquals("Two equals RandomComposites does not have the same hashCode",
        self.hashCode(), self2.hashCode());
    assertNotEquals("Two different RandomComposites have the same Hashcode", self.hashCode(), self3.hashCode());
  }
}
