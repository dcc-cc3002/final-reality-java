package cl.uchile.dcc.finalreality.exceptions;


/**
 * This error is used to represent a when an error when transitioning from a State to another.
 */
public class InvalidStateTransitionException extends Exception {

  /**
   * Creates a new {@code InvalidStateTransitionException} with a {@code description} of the
   * error.
   */
  public InvalidStateTransitionException(String description) {
    super(description);
  }
}
