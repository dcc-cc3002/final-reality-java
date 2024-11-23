package game.states;

import cl.uchile.dcc.finalreality.GameController;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidStateTransitionException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponTypeException;
import cl.uchile.dcc.finalreality.game.states.EnemyTurn;
import cl.uchile.dcc.finalreality.game.states.GameState;
import cl.uchile.dcc.finalreality.game.states.Idle;
import cl.uchile.dcc.finalreality.game.states.MageCharacterTurn;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.MageCharacter;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.magic.spell.Heal;
import cl.uchile.dcc.finalreality.model.magic.spell.Spell;
import cl.uchile.dcc.finalreality.model.magic.spell.Thunder;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThrows;

public class MageCharacterTurnTest {
  MageCharacterTurn gamestate;
  GameState gamestate1;
  GameState gamestate2;
  GameController gameController;
  MageCharacter character;
  Staff staff;
  Spell spell;

  @Before
  public void setUp() throws InvalidStatValueException, InvalidWeaponTypeException {
    gameController = new GameController();
    character = new WhiteMage("WhiteTest", 30, 10,30, gameController.getTurnsQueue());
    staff = new Staff("TestStaff", 10, 15, 30);
    spell = new Heal();
    character.equip(staff);
    character.equipSpell(spell);
    gamestate = new MageCharacterTurn(character);
    gamestate1 = new MageCharacterTurn(character);
    gamestate2 = new Idle();
    gameController.setCurrentState(gamestate);
  }

  @Test
  public void attackTest() throws InvalidStatValueException {
    assertEquals("The turn is not the expected", gamestate, gameController.getCurrentState());
    assertEquals("The Mage should have 30 Hp", 30, gamestate.getPlayerCharacter().getCurrentHp());
    gamestate.attack(gamestate.getPlayerCharacter());
    assertEquals("The turn is not the expected", new Idle(), gameController.getCurrentState());
    assertEquals("The Mage should have 25 Hp", 25, gamestate.getPlayerCharacter().getCurrentHp());
    assertNotEquals("The turn is not the expected", gamestate, gameController.getCurrentState());
  }

  @Test
  public void testEquals() {
    assertEquals("The turn is not the expected", true, gamestate.equals(gamestate));
    assertEquals("The turn is not the expected", true, gamestate.equals(gamestate1));
    assertEquals("The turn is not the expected", false, gamestate.equals(gamestate2));
  }

  @Test
  public void testHashCode() {
    assertEquals("Two equals MageTurns does not have the same hashCode",
        gamestate.hashCode(), gamestate1.hashCode());
    assertNotEquals("Two different MageTurns have the same Hashcode", gamestate.hashCode(), gamestate2.hashCode());
  }

  @Test
  public void equipWeaponTest() throws InvalidWeaponTypeException {
    assertEquals("The turn is not the expected", gamestate1, gamestate);
    assertThrows(InvalidWeaponTypeException.class, () -> gamestate.equipWeapon(new Sword("Sword", 10, 10)));
    gamestate.equipWeapon(new Staff("StaffTest", 10, 10, 10));
    assertNotEquals("The PlayerCharacter should a different staff equipped", staff, gamestate.getPlayerCharacter().getEquippedWeapon());
    assertEquals("The PlayerCharacter should a different staff equipped",
        new Staff("StaffTest", 10, 10, 10), gamestate.getPlayerCharacter().getEquippedWeapon());
    assertEquals("The turn is not the expected", gamestate1, gamestate);
  }

  @Test
  public void useSpellTest() throws InvalidStatValueException {
    assertEquals("The turn is not the expected", gamestate, gameController.getCurrentState());
    assertEquals("The Mage should have 30 Hp", 30, gamestate.getPlayerCharacter().getCurrentHp());
    gamestate.getPlayerCharacter().setCurrentHp(5);
    assertEquals("The Mage should have 5 Hp", 5, gamestate.getPlayerCharacter().getCurrentHp());
    gamestate.useSpell(character);
    assertEquals("The Mage should have 14 Hp", 14, character.getCurrentHp());
    assertNotEquals("The turn is not the expected", gamestate, gameController.getCurrentState());
    assertEquals("The turn is not the expected", new Idle(), gameController.getCurrentState());
  }

  @Test
  public void equipSpellTest() {
    assertEquals("The turn is not the expected", gamestate, gameController.getCurrentState());
    gamestate.equipSpell(new Thunder());
    assertNotEquals("The MageCharacter should a different spell equipped", spell, ((MageCharacter)gamestate.getPlayerCharacter()).getEquippedSpell());
    assertEquals("The PlayerCharacter should a different spell equipped",
        new Thunder(), ((MageCharacter)gamestate.getPlayerCharacter()).getEquippedSpell());
    assertEquals("The turn is not the expected", gamestate, gameController.getCurrentState());
  }

  @Test
  public void nextTurnTest() {
    assertThrows(InvalidStateTransitionException.class, () -> gamestate1.nextTurn());
  }
}
