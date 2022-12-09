package magicSpell;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.magicSpell.Fire;
import cl.uchile.dcc.finalreality.model.magicSpell.Heal;
import cl.uchile.dcc.finalreality.model.magicSpell.Spell;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.CompositeEffect;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.Effect;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.Heal30Effect;
import cl.uchile.dcc.finalreality.model.magicSpell.compositeEffects.NullEffect;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.*;
import static org.junit.Assert.*;

public class AbstractSpellTest {
  Spell heal;
  Spell fire;

  @Before
  public void setUp() {
    heal = new Heal();
    fire = new Fire();
  }

  @Test
  public void testGetSpell() {
    Effect eff = new Heal().getSpell();
    assertEquals("The effect should be the same", eff, heal.getSpell());
    Effect[] arr2 = {new NullEffect()};
    eff = new CompositeEffect(arr2);
    assertEquals("The effect should not be the same", heal.getSpell(), eff);
  }

  @Test
  public void testApply() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    WhiteMage whiteMage = new WhiteMage("TestKnight", 30, 10, 100, queue);
    whiteMage.setCurrentHp(21);
    heal.apply(whiteMage, whiteMage);
    assertEquals("The Mp should be 85", 85, whiteMage.getCurrentMp());
    assertEquals("The Hp should be 30", 30, whiteMage.getCurrentHp());
    heal.apply(whiteMage, whiteMage);
    assertEquals("The Hp should be 30", 30, whiteMage.getCurrentHp());
  }

  @Test
  public void testGetCost() {
    assertEquals("The cost of the Spell should be 15", 15, heal.getCost());
    assertNotEquals("The cost should not be 0", 0, fire.getCost());
  }
}