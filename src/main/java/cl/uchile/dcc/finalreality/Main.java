package cl.uchile.dcc.finalreality;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Bow;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Main class to do the testing of the features of the project.
 */
public class Main {
  /**
   * The testing of the project for this submission will be only with some prints.
   */
  public static void main(String[] args) throws InterruptedException, InvalidStatValueException {
    System.out.println("Let's begin with the testing!" + '\n');

    // Initialization of a queue.
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();

    // First we will create an instance of every class of the proyect and also
    // a Weapon, and we will equipo a Weapon to every Character.

    // Thief with a Bow:
    Thief thief = new Thief("Sram the Thief", 100, 40, queue);
    Bow bow = new Bow("Buhorado's Plume", 5, 50);
    thief.equip(bow);
    thief.waitTurn();
    // Creation of the same Thief to compare with equals method
    final Thief thief2 = new Thief("Sram the Thief", 100, 40, queue);

    // Engineer with an Axe:
    Engineer engineer = new Engineer("Steamer the Engineer", 120, 30, queue);
    Axe axe = new Axe("Cil's Axe", 10, 36);
    engineer.equip(axe);
    engineer.waitTurn();

    // Knight with a Sword:
    Knight knight = new Knight("Goultar the Knight", 5000, 300, queue);
    Sword sword = new Sword("Smiling Sword", 20, 60);
    knight.equip(sword);
    knight.waitTurn();
    // Creation of diferent Knight to compare with equals method
    final Knight knight2 = new Knight("Tristepin the Knight", 1000, 40, queue);

    // BlackMage with a Knife:
    BlackMage blackmage = new BlackMage("Nox the BlackMage", 2000, 150, 200, queue);
    Knife knife = new Knife("Ilyzaelle's Dagger's", 2, 42);
    blackmage.equip(knife);
    blackmage.waitTurn();
    blackmage.setCurrentHp(1345);
    // Creation of the same BlackMage, but it does not have recieve damage jet.
    final BlackMage blackmage2 = new BlackMage("Nox the BlackMage", 2000, 150, 200, queue);

    // WhiteMage with a Staff:
    WhiteMage whitemage = new WhiteMage("Yugo the WhiteMage", 1000, 60, 500, queue);
    Staff staff = new Staff("Zoth Manitu's Staff", 3, 1, 70);
    whitemage.equip(staff);
    whitemage.waitTurn();
    // Creation of the same WhiteMage to compare with equals method
    final WhiteMage whitemage2 = new WhiteMage("Yugo the WhiteMage", 1000, 60, 500, queue);

    // Instantation of an Enemy:
    Enemy enemy = new Enemy("Comte Harebourg the Enemy", 25, 13000, 23, 400, queue);
    enemy.waitTurn();

    // First we will test the equals methods.
    System.out.println("Testing of equals methods:" + '\n');
    System.out.println("Equals method of GameCharacters:");
    System.out.println("Are 2 Thiefs the same when all the parameters are the same? -> "
        + thief.equals(thief2));
    Thief thief3 = new Thief("Mars", 12, 220, queue);
    System.out.println("Are 2 Thiefs the same when all the parameters are diferent? -> "
        + thief.equals(thief3) + '\n');

    System.out.println("Is a Engineer also a Thief? -> " + engineer.equals(thief2));
    Engineer engineer3 = new Engineer("Steamer the Engineer", 120, 30, queue);
    System.out.println("Is a Engineer also a Engineer with the same parameters? -> "
        + engineer.equals(engineer3) + '\n');

    System.out.println("Are 2 Knights the same if some parameters are diferent? -> "
        + knight.equals(knight2));
    Knight knight3 = new Knight("Goultar the Knight", 5000, 300, queue);
    System.out.println("Are 2 Knights the same if no parameters are diferent? -> "
        + knight.equals(knight3) + '\n');

    System.out.println("Is a BlackMage the same to another BlackMage if the "
        + "current Hp is different?" + " -> " + blackmage.equals(blackmage2));
    BlackMage blackmage3 = new BlackMage("Nox the BlackMage", 2000,
        150, 200, queue);
    System.out.println("Is a BlackMage the same to another BlackMage if all parameters are"
        + " equal? -> " + blackmage2.equals(blackmage3) + '\n');

    WhiteMage whitemage3 = new WhiteMage("Oropo the Eliotrop", 2000, 20, 700, queue);
    System.out.println("Are 2 WhiteMages the same when some parameters are different? -> "
                        + whitemage.equals(whitemage3));
    System.out.println("Are 2 WhiteMages equals when all parameters are the same? -> "
        + whitemage.equals(whitemage2) + '\n');

    Enemy enemy2 = new Enemy("Comte Harebourg the Enemy", 25, 13000,
        23, 400, queue);
    System.out.println("Are 2 Enemys the same when their parametrs are equal? -> "
        + enemy.equals(enemy2));
    System.out.println("Is an Enemy also a Thief? -> " + enemy.equals(thief) + '\n');

    //------
    System.out.println("Equals method of Weapons:" + '\n');

    Bow bow2 = new Bow("Miauvizor's Bow", 5, 50);
    Bow bow3 = new Bow("Miauvizor's Bow", 5, 50);
    Staff staff2 = new Staff("Zoth Manitu's Staff", 3, 1, 70);
    Weapon sword2 = new Sword("Smiling Sword", 20, 60);
    Staff staff3 = new Staff("Romboton", 6, 3, 400);
    Knife knife2 = new Knife("Ilyzaelle's Dagger's", 2, 42);

    System.out.println("Is an Axe also a Bow? -> " + axe.equals(bow));
    System.out.println("Is an Axe equals to itself? -> " + axe.equals(axe));

    System.out.println("Is a Bow equals to another Bow with different name? -> "
        + bow2.equals(bow));
    System.out.println("Is a Bow equals to another Bow with the same parameters? -> "
        + bow2.equals(bow3));

    System.out.println("Is a Knife also a Staff? -> " + knife.equals(staff));
    System.out.println("Is a Knife equals to another Knife with the same parameters? -> "
        + knife.equals(knife2));

    System.out.println("Is a Staff the same of another Staff with the same parameters? -> "
        + staff.equals(staff2));
    System.out.println("Is a Staff the same of another Staff with different parameters? -> "
        + staff.equals(staff3));

    System.out.println("Is a Sword the equals to a Bow? -> " + sword.equals(bow));
    System.out.println("Is a Sword the same to a Sword with the same parameters"
        + " using polimorphism? -> " + sword.equals(sword2));
    System.out.println('\n');

    System.out.println("Testing of toString method:" + '\n');
    System.out.println("toString of methods for Weapons:");
    System.out.println(axe.toString());
    System.out.println(bow.toString());
    System.out.println("We will also test the getEquippedWeapon method of PlayerCharacter and "
        + "use the toString to the Weapon that the PlayerCharacter is holding at that moment:");
    System.out.println("BlackMage holing a Knife -> " + blackmage.getEquippedWeapon().toString());
    System.out.println("WhiteMage holding a Staff -> " + whitemage.getEquippedWeapon().toString());
    System.out.println("Knight holding a Sword -> " + knight.getEquippedWeapon().toString());
    System.out.println("With the previus test we have tested also the equip method, "
        + "because by default a PlayerCharacter isn't holding a Weapon and we just printed one."
        + '\n');
    System.out.println("Also we are going to test all the getters of a staff:");
    System.out.println("Name of the Staff: " + staff.getName() + ", weight of the Staff: "
            + staff.getWeight() + ", damage of the Staff: " + staff.getDamage()
            + ", magic damage of the Staff: " + staff.getMagicDamage());

    System.out.println('\n');
    System.out.println("Now we will test the toString, getWeight and the functionality of the "
        + "turns:");
    System.out.println("When we print a character, getWeight should return the weight of the Weapon"
        + " that the character is holding. In case of an enemy it will return his weight value.");
    System.out.println("We wait 5 seconds to ensure that the characters finished waiting ..."
        + '\n');

    Thread.sleep(5000); // Waiting 5 seconds
    while (!queue.isEmpty()) {
      // Pops and prints the names of the characters of the queue to illustrate the turns order
      System.out.println(queue.peek().toString() + '\n' + "The weight has a value of -> "
          + queue.poll().getWeight() + '\n');
    }

    System.out.println("Note that with this we have tested the addToQueue method, because "
        + "when we use the waitTurn method we are adding the GameCharacter to the "
        + "Queue and we just printed all the characters using the queue." + '\n');

    System.out.println("Now we are going to test the getAttack method of an enemy. "
        + "The attack of the defined enemy is -> " + enemy.getAttack() + '\n');

    System.out.println("To finish with the testing we are going to test the getters and setters "
        + "of a WhiteMage. A WhiteMage is a MageCharacter, PlayerCharacter and GameCharacter so "
        + "with this test we are testing a lot of functions.");
    System.out.println("Let's print the value of each parameter of a WhiteMage: " + '\n');
    System.out.println("Whitemage: name -> " + whitemage.getName() + ", maxHp -> "
        + whitemage.getMaxHp() + ", currentHp -> " + whitemage.getCurrentHp()
        + ", maxMp -> " + whitemage.getMaxMp() + ", currentMp -> "
        + whitemage.getCurrentMp() + ", defense -> " + whitemage.getDefense() + '\n');
    System.out.println("Let's modify his current Mp and currentHp with getters:");
    System.out.println("newHp = maxHp/2 and newMp = maxMp/3. Let's see these changes:");
    whitemage.setCurrentHp(whitemage.getMaxHp() / 2);
    whitemage.setCurrentMp(whitemage.getMaxMp() / 3);

    System.out.println(whitemage.toString() + '\n');
    System.out.println("Also we are going to print his equipped Weapon and weight of that Weapon.");
    System.out.println("equipped Weapon -> " + whitemage.getEquippedWeapon().toString());
    System.out.println("Weight of the equipped Weapon -> " + whitemage.getWeight() + '\n');

    System.out.println("With this we finished with all the tests of the current project!");




  }
}