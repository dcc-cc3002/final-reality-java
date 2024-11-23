package model.magic.spell.composite.effects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.Effect;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.NullEffect;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.ReduceHpWithMdEffect;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ReduceHpWithMdEffectTest {
  WhiteMage whiteMage;
  Effect self;
  Effect self2;
  Effect self3;

  @Before
  public void setUp() throws InvalidStatValueException, InvalidWeaponTypeException {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    whiteMage = new WhiteMage("TestKnight", 30, 2, 100, queue);
    whiteMage.equip(new Staff("TestStaff", 5, 5, 12));
    self = new ReduceHpWithMdEffect();
    self2 = new ReduceHpWithMdEffect();
    self3 = new NullEffect();
  }
  @Test
  public void applyTest() throws InvalidStatValueException {
    assertEquals("The Hp should be 30", 30, whiteMage.getCurrentHp());
    self.apply(whiteMage, whiteMage);
    assertEquals("The Hp should be 20", 20, whiteMage.getCurrentHp());
    self.apply(whiteMage, whiteMage);
    assertEquals("The Hp should be 10", 10, whiteMage.getCurrentHp());
    self.apply(whiteMage, whiteMage);
    assertEquals("The Hp should be 0", 0, whiteMage.getCurrentHp());
    self.apply(whiteMage, whiteMage);
    assertEquals("The Hp should be 0", 0, whiteMage.getCurrentHp());
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
