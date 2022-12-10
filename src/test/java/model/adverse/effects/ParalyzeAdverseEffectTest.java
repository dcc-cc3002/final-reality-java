package model.adverse.effects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
import cl.uchile.dcc.finalreality.model.adverse.effects.AdverseEffect;
import cl.uchile.dcc.finalreality.model.adverse.effects.BurnedAdverseEffect;
import cl.uchile.dcc.finalreality.model.adverse.effects.NullAdverseEffect;
import cl.uchile.dcc.finalreality.model.adverse.effects.ParalyzeAdverseEffect;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParalyzeAdverseEffectTest {
  WhiteMage whiteMage;
  AdverseEffect self;
  AdverseEffect self2;
  AdverseEffect self3;
  BlockingQueue<GameCharacter> queue;

  @Before
  public void setUp() throws InvalidStatValueException, InvalidWeaponTypeException {
    queue = new LinkedBlockingQueue<>();
    whiteMage = new WhiteMage("TestChar", 30, 10, 100, queue);
    whiteMage.equip(new Staff("TestStaff", 5, 5, 30));
    whiteMage.setAdverseEffect(new ParalyzeAdverseEffect());
    self = new ParalyzeAdverseEffect();
    self2 = new ParalyzeAdverseEffect();
    self3 = new BurnedAdverseEffect(15);
  }

  @Test
  public void applyEffectTest() throws InvalidStatValueException, InterruptedException {
    assertFalse("The whiteMage should not be in the turnsQueue", queue.contains(whiteMage));
    assertEquals("The AdverseEffect should be Paralyzed", new ParalyzeAdverseEffect(), whiteMage.getAdverseEffect());
    self.applyEffect(whiteMage);
    assertEquals("The AdverseEffect should be Paralyzed", new NullAdverseEffect(), whiteMage.getAdverseEffect());
    Thread.sleep(1000);
    assertTrue("The whiteMage should be in the turnsQueue", queue.contains(whiteMage));
  }

  @Test
  public void testEquals() {
    assertEquals("A ParalyzedAdverseEffect is not equals to itself", true, self.equals(self));
    assertEquals("A ParalyzedAdverseEffect is not equals to another ParalyzedAdverseEffect with same parameters",
        true, self.equals(self2));
    assertEquals("A ParalyzedAdverseEffect is the same as a ParalyzeAdverseEffect", false, self.equals(self3));
  }

  @Test
  public void testHashCode() {
    assertEquals("Two equals ParalyzedAdverseEffects does not have the same hashCode",
        self.hashCode(), self2.hashCode());
    assertNotEquals("Two different ParalyzedAdverseEffects have the same Hashcode", self.hashCode(), self3.hashCode());
  }
}
