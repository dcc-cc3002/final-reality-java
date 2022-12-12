package model.magic.spell.composite.effects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
import cl.uchile.dcc.finalreality.model.adverse.effects.BurnedAdverseEffect;
import cl.uchile.dcc.finalreality.model.adverse.effects.NullAdverseEffect;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.BurnEffect;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.Effect;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.NullEffect;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BurnEffectTest {
  WhiteMage whiteMage;
  Effect self;
  Effect self2;
  Effect self3;

  @Before
  public void setUp() throws InvalidStatValueException, InvalidWeaponTypeException {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    whiteMage = new WhiteMage("TestKnight", 30, 10, 100, queue);
    whiteMage.equip(new Staff("TestStaff", 5, 5, 30));
    self = new BurnEffect();
    self2 = new BurnEffect();
    self3  = new NullEffect();
  }
  @Test
  public void applyTest() throws InvalidStatValueException {
    assertEquals("The AdverseEffect is not the expected", new NullAdverseEffect(), whiteMage.getAdverseEffect());
    self.apply(whiteMage, whiteMage);
    assertEquals("The AdverseEffect is not the expected", new BurnedAdverseEffect(30/2), whiteMage.getAdverseEffect());
  }

  @Test
  public void testEquals() {
    assertEquals("A BurnEffect is not equals to itself", true, self.equals(self));
    assertEquals("A BurnEffect is not equals to another Knight with same parameters",
        true, self.equals(self2));
    assertEquals("A BurnEffect is the same as a WhiteMage", false, self.equals(self3));
  }

  @Test
  public void testHashCode() {
    assertEquals("Two equals BurnEffects does not have the same hashCode",
        self.hashCode(), self2.hashCode());
    assertNotEquals("Two different BurnEffects have the same Hashcode", self.hashCode(), self3.hashCode());
  }
}