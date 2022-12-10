package model.adverse.effects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
import cl.uchile.dcc.finalreality.model.adverse.effects.AdverseEffect;
import cl.uchile.dcc.finalreality.model.adverse.effects.ParalyzeAdverseEffect;
import cl.uchile.dcc.finalreality.model.adverse.effects.PoisonAdverseEffect;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PoisonAdverseEffectTest {
  WhiteMage whiteMage;
  AdverseEffect self;
  AdverseEffect self2;
  AdverseEffect self3;

  @Before
  public void setUp() throws InvalidStatValueException, InvalidWeaponTypeException {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    whiteMage = new WhiteMage("TestChar", 30, 10, 100, queue);
    whiteMage.equip(new Staff("TestStaff", 5, 5, 30));
    self = new PoisonAdverseEffect(whiteMage.getEquippedWeapon().getMagicDamage()/3);
    self2 = new PoisonAdverseEffect(10);
    self3 = new ParalyzeAdverseEffect();
  }

  @Test
  public void applyEffectTest() throws InvalidStatValueException {
    assertEquals("The Hp should be 30", 30, whiteMage.getCurrentHp());
    self.applyEffect(whiteMage);
    assertEquals("The Hp should be 20", 20, whiteMage.getCurrentHp());
    self.applyEffect(whiteMage);
    assertEquals("The Hp should be 10", 10, whiteMage.getCurrentHp());
    self.applyEffect(whiteMage);
    assertEquals("The Hp should be 0", 0, whiteMage.getCurrentHp());
  }

  @Test
  public void testEquals() {
    assertEquals("A PoisonAdverseEffect is not equals to itself", true, self.equals(self));
    assertEquals("A PoisonAdverseEffect is not equals to another PoisonAdverseEffect with same parameters",
        true, self.equals(self2));
    assertEquals("A PoisonAdverseEffect is the same as a ParalyzeAdverseEffect", false, self.equals(self3));
  }

  @Test
  public void testHashCode() {
    assertEquals("Two equals PoisonAdverseEffects does not have the same hashCode",
        self.hashCode(), self2.hashCode());
    assertNotEquals("Two different PoisonAdverseEffects have the same Hashcode", self.hashCode(), self3.hashCode());
  }
}
