package magicSpell.compositeEffects;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.Effect;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.Heal30Effect;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.NullEffect;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NullEffectTest {
  WhiteMage whiteMage;
  Effect self;

  @Before
  public void setUp() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    whiteMage = new WhiteMage("TestKnight", 30, 10, 100, queue);
    self = new NullEffect();
  }
  @Test
  public void applyTest() throws InvalidStatValueException {
    whiteMage.setCurrentHp(21);
    assertEquals("The Hp should be 21", 21, whiteMage.getCurrentHp());
    self.apply(whiteMage, whiteMage);
    assertEquals("The Hp should be 21", 21, whiteMage.getCurrentHp());
  }
}