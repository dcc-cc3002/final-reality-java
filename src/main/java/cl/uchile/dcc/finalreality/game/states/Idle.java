package cl.uchile.dcc.finalreality.game.states;

public class Idle extends AbstractGameState {

  @Override
  public void nextTurn() throws InterruptedException {
    while (!(context.getTurnsQueue().isEmpty())) {
      Thread.sleep(100);
    }
    context.getTurnsQueue().poll().beginTurn(this);
  }
}
