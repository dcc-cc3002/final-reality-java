package model.magic.spell;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.magic.spell.Heal;
import cl.uchile.dcc.finalreality.model.magic.spell.NullSpell;
import cl.uchile.dcc.finalreality.model.magic.spell.Spell;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class HealTest {
  Spell self;
  Spell self2;
  Spell self3;

  @Before
  public void setUp() throws InvalidStatValueException {
    self = new Heal();
    self2 = new Heal();
    self3 = new NullSpell();
  }

  @Test
  public void testEquals() {
    assertEquals("A Heal is not equals to itself", true, self.equals(self));
    assertEquals("A Heal is not equals to another Heal with same parameters",
        true, self.equals(self2));
    assertEquals("A Heal is the same as a NullSpell", false, self.equals(self3));
  }

  @Test
  public void testHashCode() {
    assertEquals("Two equals Heals does not have the same hashCode",
        self.hashCode(), self2.hashCode());
    assertNotEquals("Two different Heals have the same Hashcode", self.hashCode(), self3.hashCode());
  }
}
