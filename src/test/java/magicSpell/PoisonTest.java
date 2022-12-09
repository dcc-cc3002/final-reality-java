package magicSpell;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.magicSpell.NullSpell;
import cl.uchile.dcc.finalreality.model.magicSpell.Poison;
import cl.uchile.dcc.finalreality.model.magicSpell.Spell;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PoisonTest {
  Spell self;
  Spell self2;
  Spell self3;

  @Before
  public void setUp() throws InvalidStatValueException {
    self = new Poison();
    self2 = new Poison();
    self3 = new NullSpell();
  }

  @Test
  public void testEquals() {
    assertEquals("A Fire is not equals to itself", true, self.equals(self));
    assertEquals("A Fire is not equals to another Fire with same parameters",
        true, self.equals(self2));
    assertEquals("A Fire is the same as a NullSpell", false, self.equals(self3));
  }

  @Test
  public void testHashCode() {
    assertEquals("Two equals Fires does not have the same hashCode",
        self.hashCode(), self2.hashCode());
    assertNotEquals("Two different Fires have the same Hashcode", self.hashCode(), self3.hashCode());
  }
}
