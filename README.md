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
and a name. In the case of a Black Mage's and White Mage's they also have a Mp value, we call those characters
_MageCharacers_. Every _PlayerCharacter_ can also equip ceartain Weapons. In the other hand, all _MageCharacters_ 
can equip spells.  

The user can also instanciate _Weapon_'s. There are 5 types of Weapons; Axe's, Sword's, Knives, Bow's and Staff's.
Every _Weapon_ have a name, a weight and an attack value, and in the case of a Staff it also has a magic damage value.  

There also exists Enemy's. An enemy is very similar to a _PlayerCharacter_, but this time the user shouldn't
control it. An Enemy have a name, defense, Hp, weight and an attack value. It differentiates from _PlayerCharacter_'s
because it cannot equip any weapons or spells.  

We consider de group of Enemy's and PlayerCharacter as _GameCharacter_'s. Every _GameCharacter_ is cappable of entering
to a battle, where they must wait they turn to attack. How frequently a _GameCharacter_ can act in a battle is determined
by his weight and every time they attack, they must after wait for their turn. The battle lasts until all PlayerCharacets or Enemies have died.

---
### Tarea 3 - Cambios efectuados
**This section will be written in Spanish to simplify the correction of this assignment.**  

Respecto a la entrega de la tarea 2, no se cambió ningun archivo debido a que la implementacion fue la adecuada.  

Ahora, respecto a la tarea 3, en primer lugar se implementaron los hechizos del juego. Esto fue mediante un patron de 
composite para los efectos de estos. También se hizó que los magos puedan equiparse hechizos y utilizarlos, además de 
implementar efectos y hechizos nulos con el patrón Null-Object para evitar checkear si es que el hechizo o su efecto 
es nulo.  

Luego, se implementó un GameController que maneja como los personajes se atacan entre sí, como usan hechizo entre sí y 
toda la logistica detras de estas acciones. Algunos ejemplos de esto es dañar al objetivo, restar el costo de uso de 
los hechizos, no utilizar un hechizo si no se tiene el Mp requerido, etc...  

También se implementó un patron de diseño observer para observar cuando un personaje muere y reaccionar desde el 
GameController a este cambio. Se reacciona quitando al personaje en cuestion de su respectivo arreglo y de la cola de 
turnos, además de checkear si se terminó la batalla y transicionar a un estado de término si esto sucedió.  

Por otro lado, se implementaron los efectos Adversos. Esto fue mediante un atributo en los GameCharacters que simboliza 
que efecto adverso poseen. En caso de que no tengan efecto adverso se tiene uno nulo (Nuevamente con el patron 
Null-Object). Un personaje recibe el efecto del efecto adverso al iniciar su turno y solo puede tener 1 efecto adverso 
a la vez. Para esta implementacion se decidio que si un personaje por ejemplo está quemado y se intenta paralizarlo,
entonces el estado quemado es reemplazado por el estado paralizado.  

Luego, se implementó todo el sistema de turnos con un patron State. Este funciona con un estado neutro llamado Idle que se encarga de 
encontrar al siguiente personaje a quien le toca pelear. Luego existen 3 clases para estos turnos, un estado para el 
turno de los enemigos, otro estado para el turno de los jugadores y otro último para los turnos de jugadores magos. 
El estado turno de jugador mago es subclase del de un jugador normal pues un mago es también un jugador normal y 
puede hacer lo mismo que estos además de equiparse y usar hechizos. Luego, para cuando una batalla finaliza existe un 
estado de término llamado EndState que evita que un posible futuro cliente haga acciones después de que se termine la 
batalla.  

Para finalizar también cabe mencionar que se testearon absolutamente todas las clases, metodos y líneas agregadas. 
Se mantiene el mismo coverage del 99% a través de los 194 tests.  

Para terminar, solo queria decirle a quien esté leyendo esto que tenga un buen dia <3