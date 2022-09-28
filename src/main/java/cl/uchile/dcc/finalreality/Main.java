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
    System.out.println("Is a Engineer also a Thief? -> " + engineer.equals(thief2));
    System.out.println("Are 2 Knights the same if some parameters are diferent? -> "
        + knight.equals(knight2));
    System.out.println("Is a Engineer also a Thief? -> " + engineer.equals(thief2));
    System.out.println("Is a BlackMage the same to another BlackMage if the "
        + "current Hp is different?" + " -> " + blackmage.equals(blackmage2));
    System.out.println("Are 2 WhiteMages the same when all the parameters are the same? -> "
                        + whitemage.equals(whitemage2));
    System.out.println("Is an Enemy also a Thief? -> " + enemy.equals(thief) + '\n');
    System.out.println("Equals method of Weapons:");

    Bow bow2 = new Bow("Miauvizor's Bow", 5, 50);
    Staff staff2 = new Staff("Zoth Manitu's Staff", 3, 1, 70);
    Weapon sword2 = new Sword("Smiling Sword", 20, 60);

    System.out.println("Is an Axe also a Bow? -> " + axe.equals(bow));
    System.out.println("Is a Bow equals to another Bow with different name? -> "
        + bow2.equals(bow));
    System.out.println("Is a Knife also a Staff? -> " + knife.equals(staff));
    System.out.println("Is an Staff the as another Staff with the same parameters? -> "
        + staff.equals(staff2));
    System.out.println("Is a Sword the same to a Sword with the same parameters"
        + " using polimorphism? -> " + sword.equals(sword2));
    System.out.println('\n');

    System.out.println("Testing of toString method:" + '\n');
    System.out.println("toString of methods for Weapons:");
    System.out.println(axe.toString());
    System.out.println(bow.toString());
    System.out.println(knife.toString());
    System.out.println(staff.toString());
    System.out.println(sword.toString());


  }
}