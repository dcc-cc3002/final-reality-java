package cl.uchile.dcc.finalreality.exceptions;

/**
 * This error is used to represent a when a Weapon is not equipable by a character.
 *
 * @author <a href="https://github.com/r8vnhill">R8V</a>
 * @author ~Arturo Kullmer~
 */
public class InvalidWeaponTypeException extends Exception {

  /**
   * Creates a new {@code InvalidWeaponTypeException} with a {@code description} of the
   * error.
   */
  public InvalidWeaponTypeException(String description) {
    super(description);
  }
}
