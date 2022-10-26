package character;

import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import org.junit.Before;

public class AbstractCharacterTest {
  GameCharacter enemy;
  GameCharacter engineer;
  GameCharacter whitemage;
  Thief thief;

  @Before
  public void setUp() {
    enemy = new Enemy("Comte Harebourg the Enemy", 25, 13000, 23, 400, queue);
  }
}
