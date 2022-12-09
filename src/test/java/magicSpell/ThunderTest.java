package magicSpell;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.magicSpell.NullSpell;
import cl.uchile.dcc.finalreality.model.magicSpell.Thunder;
import cl.uchile.dcc.finalreality.model.magicSpell.Spell;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ThunderTest {
  Spell self;
  Spell self2;
  Spell self3;

  @Before
  public void setUp() throws InvalidStatValueException {
    self = new Thunder();
    self2 = new Thunder();
    self3 = new NullSpell();
  }

  @Test
  public void testEquals() {
    assertEquals("A Thunder is not equals to itself", true, self.equals(self));
    assertEquals("A Thunder is not equals to another Thunder with same parameters",
        true, self.equals(self2));
    assertEquals("A Thunder is the same as a NullSpell", false, self.equals(self3));
  }

  @Test
  public void testHashCode() {
    assertEquals("Two equals Thunders does not have the same hashCode",
        self.hashCode(), self2.hashCode());
    assertNotEquals("Two different Thunders have the same Hashcode", self.hashCode(), self3.hashCode());
  }
}
