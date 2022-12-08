package cl.uchile.dcc.finalreality.model;

public interface Subscriber {
  /**
   * The subscriber reacts to a change of the publisher.
   */
  void update();
}
