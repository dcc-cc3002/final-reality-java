package model.adverse.effects;

import cl.uchile.dcc.finalreality.GameController;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
import cl.uchile.dcc.finalreality.game.states.GameState;
import cl.uchile.dcc.finalreality.game.states.Idle;
import cl.uchile.dcc.finalreality.game.states.MageCharacterTurn;
import cl.uchile.dcc.finalreality.model.adverse.effects.AdverseEffect;
import cl.uchile.dcc.finalreality.model.adverse.effects.BurnedAdverseEffect;
import cl.uchile.dcc.finalreality.model.adverse.effects.NullAdverseEffect;
import cl.uchile.dcc.finalreality.model.adverse.effects.ParalyzeAdverseEffect;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParalyzeAdverseEffectTest {
  WhiteMage whiteMage;
  AdverseEffect self;
  AdverseEffect self2;
  AdverseEffect self3;
  BlockingQueue<GameCharacter> queue;
  GameController gameController;
  GameState gameState;
  GameState gameState2;

  @Before
  public void setUp() throws InvalidStatValueException, InvalidWeaponTypeException {
    queue = new LinkedBlockingQueue<>();
    whiteMage = new WhiteMage("TestChar", 30, 10, 100, queue);
    whiteMage.equip(new Staff("TestStaff", 5, 5, 30));
    whiteMage.setAdverseEffect(new ParalyzeAdverseEffect());
    self = new ParalyzeAdverseEffect();
    self2 = new ParalyzeAdverseEffect();
    self3 = new BurnedAdverseEffect(15);
    gameState = new MageCharacterTurn(whiteMage);
    gameState2 = new Idle();
    gameController = new GameController();
  }

  @Test
  public void applyEffectTest() throws InvalidStatValueException, InterruptedException {
    gameController.setCurrentState(gameState);
    assertEquals("The Gamestate should be in the mages turn", gameState, gameController.getCurrentState());
    assertFalse("The whiteMage should not be in the turnsQueue", queue.contains(whiteMage));
    assertEquals("The AdverseEffect should be Paralyzed", new ParalyzeAdverseEffect(), whiteMage.getAdverseEffect());
    self.applyEffect(whiteMage, gameState);
    assertEquals("The Gamestate should be in the Idle", gameState2, gameController.getCurrentState());
    assertEquals("The AdverseEffect should be NullEffect", new NullAdverseEffect(), whiteMage.getAdverseEffect());
    Thread.sleep(1000);
    assertTrue("The whiteMage should be in the turnsQueue", queue.contains(whiteMage));
  }

  @Test
  public void testEquals() {
    assertEquals("A ParalyzedAdverseEffect is not equals to itself", true, self.equals(self));
    assertEquals("A ParalyzedAdverseEffect is not equals to another ParalyzedAdverseEffect with same parameters",
        true, self.equals(self2));
    assertEquals("A ParalyzedAdverseEffect is the same as a ParalyzeAdverseEffect", false, self.equals(self3));
  }

  @Test
  public void testHashCode() {
    assertEquals("Two equals ParalyzedAdverseEffects does not have the same hashCode",
        self.hashCode(), self2.hashCode());
    assertNotEquals("Two different ParalyzedAdverseEffects have the same Hashcode", self.hashCode(), self3.hashCode());
  }
}
