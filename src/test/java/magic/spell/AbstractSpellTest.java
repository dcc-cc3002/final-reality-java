package magic.spell;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.magic.spell.Fire;
import cl.uchile.dcc.finalreality.model.magic.spell.Heal;
import cl.uchile.dcc.finalreality.model.magic.spell.Spell;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.CompositeEffect;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.Effect;
import cl.uchile.dcc.finalreality.model.magic.spell.composite.effects.NullEffect;
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
    Effect eff2 = new CompositeEffect(arr2);
    assertNotEquals("The effect should not be the same", heal.getSpell(), eff2);
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