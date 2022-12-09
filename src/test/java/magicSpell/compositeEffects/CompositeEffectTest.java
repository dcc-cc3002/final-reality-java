package magicSpell.compositeEffects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
import cl.uchile.dcc.finalreality.model.adverseEffects.NullAdverseEffect;
import cl.uchile.dcc.finalreality.model.adverseEffects.ParalyzeAdverseEffect;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.*;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CompositeEffectTest {
  Effect[] effects = new Effect[3];
  Effect[] effects2 = new Effect[3];
  Effect[] effects3 = new Effect[1];

  Effect composite;
  Effect composite2;
  Effect composite3;
  Effect nullEffect = new NullEffect();
  WhiteMage whiteMage;
  @Before
  public void setUp() throws InvalidStatValueException, InvalidWeaponTypeException {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    whiteMage = new WhiteMage("TestComposite", 30, 10, 100, queue);
    whiteMage.equip(new Staff("TestStaff", 5, 5, 30));
    effects[0] = new ReduceHpWithMdEffect();
    effects2[0] = new ReduceHpWithMdEffect();
    effects[1] = new ParalyzeEffect();
    effects2[1] = new ParalyzeEffect();
    effects[2] = new NullEffect();
    effects2[2] = new NullEffect();
    composite = new CompositeEffect(effects);
    composite2 = new CompositeEffect(effects2);
    effects3[0] = new PoisonEffect();
    composite3 = new CompositeEffect(effects3);
  }

  @Test
  public void applyTest() throws InvalidStatValueException {
    assertEquals("The Hp should be 30", 30, whiteMage.getCurrentHp());
    assertEquals("The AdverseEffect is not the expected", new NullAdverseEffect(), whiteMage.getAdverseEffect());
    composite.apply(whiteMage, whiteMage);
    assertEquals("The Hp should be 10", 10, whiteMage.getCurrentHp());
    assertEquals("The AdverseEffect is not the expected", new ParalyzeAdverseEffect(), whiteMage.getAdverseEffect());
  }

  @Test
  public void testEquals() {
    assertEquals("A Composite is not equals to itself", true, composite.equals(composite));
    assertEquals("A Composite is not equals to another Composite with same parameters",
        true, composite.equals(composite2));
    assertEquals("A Composite is the same as a NullEffect", false, composite.equals(nullEffect));
  }

  @Test
  public void testHashCode() {
    assertEquals("Two equals Composites does not have the same hashCode",
        composite.hashCode(), composite2.hashCode());
    assertNotEquals("Two different Composites have the same Hashcode", composite.hashCode(), composite3.hashCode());
  }
}
