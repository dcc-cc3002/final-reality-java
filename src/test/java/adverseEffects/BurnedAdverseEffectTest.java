package adverseEffects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
import cl.uchile.dcc.finalreality.model.adverseEffects.AdverseEffect;
import cl.uchile.dcc.finalreality.model.adverseEffects.BurnedAdverseEffect;
import cl.uchile.dcc.finalreality.model.adverseEffects.ParalyzeAdverseEffect;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BurnedAdverseEffectTest {
  WhiteMage whiteMage;
  AdverseEffect self;
  AdverseEffect self2;
  AdverseEffect self3;

  @Before
  public void setUp() throws InvalidStatValueException, InvalidWeaponTypeException {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    whiteMage = new WhiteMage("TestChar", 30, 10, 100, queue);
    whiteMage.equip(new Staff("TestStaff", 5, 5, 30));
    self = new BurnedAdverseEffect(whiteMage.getEquippedWeapon().getMagicDamage()/2);
    self2 = new BurnedAdverseEffect(15);
    self3 = new ParalyzeAdverseEffect();
  }

  @Test
  public void applyEffectTest() throws InvalidStatValueException {
    assertEquals("The Hp should be 30", 30, whiteMage.getCurrentHp());
    self.applyEffect(whiteMage);
    assertEquals("The Hp should be 15", 15, whiteMage.getCurrentHp());
    self.applyEffect(whiteMage);
    assertEquals("The Hp should be 0", 0, whiteMage.getCurrentHp());
    self.applyEffect(whiteMage);
    assertEquals("The Hp should be 0", 0, whiteMage.getCurrentHp());
  }

  @Test
  public void testEquals() {
    assertEquals("A BurnedAdverseEffect is not equals to itself", true, self.equals(self));
    assertEquals("A BurnedAdverseEffect is not equals to another BurnedAdverseEffect with same parameters",
        true, self.equals(self2));
    assertEquals("A BurnedAdverseEffect is the same as a ParalyzeAdverseEffect", false, self.equals(self3));
  }

  @Test
  public void testHashCode() {
    assertEquals("Two equals BurnedAdverseEffects does not have the same hashCode",
        self.hashCode(), self2.hashCode());
    assertNotEquals("Two different BurnedAdverseEffects have the same Hashcode", self.hashCode(), self3.hashCode());
  }
}
