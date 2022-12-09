package magicSpell.compositeEffects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.Effect;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.Heal30Effect;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.ReduceHpWithMdEffect;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ReduceHpWithMdEffectTest {
  WhiteMage whiteMage;
  Effect self;

  @Before
  public void setUp() throws InvalidStatValueException, InvalidWeaponTypeException {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    whiteMage = new WhiteMage("TestKnight", 30, 2, 100, queue);
    whiteMage.equip(new Staff("TestStaff", 5, 5, 12));
    self = new ReduceHpWithMdEffect();
  }
  @Test
  public void applyTest() throws InvalidStatValueException {
    assertEquals("The Hp should be 30", 30, whiteMage.getCurrentHp());
    self.apply(whiteMage, whiteMage);
    assertEquals("The Hp should be 20", 20, whiteMage.getCurrentHp());
    self.apply(whiteMage, whiteMage);
    assertEquals("The Hp should be 10", 10, whiteMage.getCurrentHp());
  }
}
