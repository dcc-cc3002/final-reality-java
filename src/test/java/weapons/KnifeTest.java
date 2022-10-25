package weapons;

import cl.uchile.dcc.finalreality.model.weapon.Bow;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class KnifeTest {
  Knife knife;
  Weapon knife2;
  Knife knife3;
  Bow bow;

  @Before
  public void setUp() {
    knife = new Knife("Zeyko's Dagger's", 5, 42);
    knife2 = new Knife("Zeyko's Dagger's", 5, 42);
    knife3 = new Knife("Ilyzaelle's Dagger's", 2, 42);
    bow = new Bow("Miauvizor's Bow", 5, 50);
  }

  @Test
  public void testEquals() {
    assertEquals("A Knife is not equals to itself", true, knife.equals(knife));
    assertEquals("A Knife is not equals to another Knife with same parameters", true, knife.equals(knife2));
    assertNotEquals("A Knife is equals to another Knife with diferent name and weight value", true, knife3.equals(knife));
    assertEquals("A Knife is the same as a Bow", false, knife.equals(bow));

  }

  @Test
  public void testHashCode() {
    assertEquals("Two equals Knives does not have the same hashCode",
        knife.hashCode(), knife2.hashCode());
    assertNotEquals("Two different Knives have the same Hashcode", knife.hashCode(), knife3.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("toString method does not work in the Knife class", "Knife{name='" + knife.getName() +
        "', weight=" + knife.getWeight() + ", damage=" + knife.getDamage() + "}", knife.toString());
    assertNotEquals("toString method does'nt work in the Knife class", knife3.toString(), knife.toString());
  }

}
