package cl.uchile.dcc.finalreality;

import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class GameController {
  private BlockingQueue<GameCharacter> turnsQueue;
  private ArrayList<PlayerCharacter> playerCharacters;
  private ArrayList<Enemy> enemies;

  public GameController() {
  }
}
