Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and a group of 
enemies controlled by the computer.

---
### Context for the user

In this project you can create instances of 5 type of specific class of a Character; Knight, Thief
, Engineer, Black Mage and White Mage.  

Those characters are the ones you as the user can use.
We classify these characters as _PlayerCharacters_ and every single one of them have a Hp value, defense
and a name. In the case of a Black Mage's and White Mage's they also have a Mp value. Every _PlayerCharacter_
can also equip ceartain Weapons.  

The user can also instanciate _Weapon_'s. There are 5 types of Weapons; Axe's, Sword's, Knives, Bow's and Staff's.
Every _Weapon_ have a name, a weight and an attack value, and in the case of a Staff it also has a magic damage value.  

There also exists Enemy's. An enemy is very similar to a _PlayerCharacter_, but this time the user shouldn't
control it. An Enemy have a name, defense, Hp, weight and an attack value. It differentiates from _PlayerCharacter_'s
because it cannot equip any weapons.  

We consider de group of Enemy's and PlayerCharacter as _GameCharacter_'s. Every _GameCharacter_ is cappable of entering
to a battle, where they must wait they turn to attack. How frequently a _GameCharacter_ can act in a battle is determined
by his weight and every time they attack, they must after wait for their turn. Note that there is no implementation of a 
battle system in this project jet.

---
### Tarea 2 - Cambios efectuados
**This section will be written in Spanish to simplify the correction of this assignment.**  

Respecto a la entrega de la tarea 1, se eliminó la clase abstracta con su interfaz Item, esto debido a 
que su existencia no tiene relevancia en el projecto actualmente. También se modificó el metodo getWeight()
de la clase AbstractPlayerCharacter para que ahora arroje una excepcion en caso de que un PlayerCharacter 
use este metodo sin tener un arma equipada.

Ahora, para la tarea 2 se pidió hacer testing. Para elló se creó el paquete test y se crearon tests para
absolutamente todas las funcionalidades de la tarea 1. No hay más que comentar respecto a eso.  

Luego, respecto a implementar las restricciones de equipar armas a ciertos personajes. Para solucionar este
problema se hizó que cada personaje haga un double dispatch al momento de equipar un arma. Esto mediante 
la implementacion de metodos **EquipTo[Personaje]** en cada arma. Cada arma implementa metodos EquipTo para los 
personajes que pueden equipar tal arma y para los personajes que no pueden equiparse tal arma AbstractWeapon
se encarga de tirar una excepcion. Como AbstractWeapon es una clase abstracta tiene sentido que no pueda equiparse 
a ningun personaje y además si en un futuro se crea una nueva arma, entonces tal arma solo debera precuparse de 
implementar los metodos EquipTo para los personajes que pueden equipar esa arma. 
También, de esta manera se evita la utilizacion de _instanceof_ y se siguen las buenas prácticas enseñadas
en el curso.  

Cabe notar además que el metodo equip ahora es abstracto en _AbstractPlayerCharacter_ para que cada personaje 
en particular se encargue de enviar el mensaje adecuado a las armas y realizar el double dispatch de manera 
exitosa. Asi también nos aseguramos que si en el futuro se implementa un nuevo personaje, entonces estará obligado a 
implementar tal metodo y se cumple y mantiene el principio de Liskov.  

También se hizo testing de todos los metodos nuevos implementados.

Para terminar, solo queria decirle a quien esté leyendo esto que tenga un buen dia <3