package cl.uchile.dcc.finalreality.game.states;

import cl.uchile.dcc.finalreality.model.character.Enemy;

public class EnemyTurn extends AbstractGameState {
  private Enemy enemy;

  public EnemyTurn(Enemy enemy) {
    this.enemy = enemy;
  }
}
