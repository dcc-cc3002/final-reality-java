package model.character.player;

import cl.uchile.dcc.finalreality.GameController;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidStateTransitionException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
import cl.uchile.dcc.finalreality.game.states.Idle;
import cl.uchile.dcc.finalreality.game.states.MageCharacterTurn;
import cl.uchile.dcc.finalreality.model.adverse.effects.BurnedAdverseEffect;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.magic.spell.Fire;
import cl.uchile.dcc.finalreality.model.magic.spell.Spell;
import cl.uchile.dcc.finalreality.model.magic.spell.Thunder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AbstractMageCharacterTest {
  MageCharacter whitemage;
  MageCharacter blackmage;
  Spell thunder;
  Spell defaultSpell;
  Spell fire;
  BlockingQueue<GameCharacter> queue;
  GameController gameController;

  @Before
  public void setUp() throws InvalidStatValueException, InvalidWeaponTypeException {
    queue = new LinkedBlockingQueue<>();
    whitemage = new WhiteMage("Yugo the WhiteMage", 1000, 60, 500, queue);
    blackmage = new BlackMage("Nox the BlackMage", 2000, 150, 200, queue);
    thunder = new Thunder();
    defaultSpell = whitemage.getEquippedSpell();
    fire = new Fire();
    gameController = new GameController();
  }

  @Test
  public void getMaxMpTest() throws InvalidStatValueException {
    assertEquals("The MaxMp value does not equal to the expected", 500, whitemage.getMaxMp());
    whitemage.setCurrentMp(400);
    assertNotEquals("The MaxMp is equals when it should not", 400, whitemage.getMaxMp());
  }

  @Test
  public void getCurrentMpTest() throws InvalidStatValueException {
    assertEquals("The currentMp does not equal to the expected", whitemage.getMaxMp(), whitemage.getCurrentMp());
    whitemage.setCurrentMp(whitemage.getMaxMp()/5);
    assertNotEquals("The CurrentMp is not the expected", whitemage.getMaxMp(), whitemage.getCurrentMp());
  }

  @Test
  public void setCurrentMpTest() throws InvalidStatValueException {
    whitemage.setCurrentMp(0);
    assertEquals("setCurrentMp is not working as intended", 0, whitemage.getCurrentMp());
    assertThrows(InvalidStatValueException.class, () -> whitemage.setCurrentMp(-1));
    assertThrows(InvalidStatValueException.class, () -> whitemage.setCurrentMp(whitemage.getMaxMp()+1));
    assertNotEquals("setCurrentMp should not be equals", whitemage.getMaxMp(), whitemage.getCurrentMp());
  }

  @Test
  public void getSpellTest() {
    assertEquals("The default thunder does not equal to the expected", whitemage.getEquippedSpell(), defaultSpell);
    whitemage.equipSpell(thunder);
    assertEquals("The Spell is not the expected", whitemage.getEquippedSpell(), thunder);
    assertNotEquals("The Spell is not the expected", whitemage.getEquippedSpell(), fire);
  }

  @Test
  public void equipSpellTest() {
    whitemage.equipSpell(thunder);
    assertEquals("The Spell is not the expected", whitemage.getEquippedSpell(), thunder);
    assertNotEquals("The Spell is not the expected", whitemage.getEquippedSpell(), fire);
    whitemage.equipSpell(fire);
    assertEquals("The Spell is not the expected", whitemage.getEquippedSpell(), fire);
  }

  @Test
  public void beginTurnTest() throws InvalidStateTransitionException, InvalidStatValueException, InterruptedException {
    gameController.getPlayerCharacters().add(whitemage);
    whitemage.subscribe(gameController);
    whitemage.setAdverseEffect(new BurnedAdverseEffect(100));
    assertEquals("The Player should not have recived poison damage", 1000, whitemage.getCurrentHp());
    assertEquals("The GameState should be Idle", new Idle(), gameController.getCurrentState());
    whitemage.beginTurn(gameController.getCurrentState());
    assertEquals("The GameState should be PlayerCharacterTurn", new MageCharacterTurn(whitemage), gameController.getCurrentState());
    assertEquals("The Player should have recived poison damage", 900, whitemage.getCurrentHp());
    whitemage.notifySubscribersDeath();
    gameController.setCurrentState(new Idle());
    whitemage.beginTurn(gameController.getCurrentState());
    assertNotEquals("The next turn should not be the turn of this whitemage", new MageCharacterTurn(whitemage), gameController.getCurrentState());
  }
}