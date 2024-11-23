package model.adverse.effects;

import cl.uchile.dcc.finalreality.GameController;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
import cl.uchile.dcc.finalreality.game.states.GameState;
import cl.uchile.dcc.finalreality.game.states.Idle;
import cl.uchile.dcc.finalreality.game.states.MageCharacterTurn;
import cl.uchile.dcc.finalreality.model.adverse.effects.AdverseEffect;
import cl.uchile.dcc.finalreality.model.adverse.effects.BurnedAdverseEffect;
import cl.uchile.dcc.finalreality.model.adverse.effects.ParalyzeAdverseEffect;
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
  GameController gameController;
  GameState gameState;
  GameState gameState2;

  @Before
  public void setUp() throws InvalidStatValueException, InvalidWeaponTypeException {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    whiteMage = new WhiteMage("TestChar", 30, 10, 100, queue);
    whiteMage.equip(new Staff("TestStaff", 5, 5, 30));
    self = new BurnedAdverseEffect(whiteMage.getEquippedWeapon().getMagicDamage()/2);
    self2 = new BurnedAdverseEffect(15);
    self3 = new ParalyzeAdverseEffect();
    gameState = new MageCharacterTurn(whiteMage);
    gameState2 = new Idle();
    gameController = new GameController();
  }

  @Test
  public void applyEffectTest() throws InvalidStatValueException {
    assertEquals("The Gamestate should be in the Idle", gameState2, gameController.getCurrentState());
    gameController.setCurrentState(gameState);
    assertEquals("The Gamestate should be in the mages turn", gameState, gameController.getCurrentState());
    assertEquals("The Hp should be 30", 30, whiteMage.getCurrentHp());
    self.applyEffect(whiteMage, gameState);
    assertEquals("The Hp should be 15", 15, whiteMage.getCurrentHp());
    assertEquals("The Gamestate should be in the mages turn", gameState, gameController.getCurrentState());
    self.applyEffect(whiteMage, gameState);
    assertEquals("The Hp should be 0", 0, whiteMage.getCurrentHp());
    assertEquals("The Gamestate should be in the Idle", gameState2, gameController.getCurrentState());
    self.applyEffect(whiteMage, gameState);
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
