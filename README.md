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
can also equip a _Weapon_.  

The user can also instanciate _Weapon_'s. There are 5 types of Weapons; Axe's, Sword's, Knives, Bow's and Staff's.
Every _Weapon_ have a name, a weight and an attack value, and in the case of a Staff it also has a magic damage value.  

There also exists Enemy's. An enemy is very similar to a _PlayerCharacter_, but this time the user shouldn't
control it. An Enemy have a name, defense, Hp, weight and an attack value. It differizates from _PlayerCharacter_'s
because it cannot equip any weapons.  

We consider de group of Enemy's and PlayerCharacter as _GameCharacter_'s. Every _GameCharacter_ is cappable of entering
to a battle, where they must wait they turn to attack. How frequently a _GameCharacter_ can act in a battle is determined
by his weight and every time they attack, they must after wait for their turn. Note that there is no implementation of a 
battle system in this project jet.

---
### Tarea 1 - Cambios efectuados
**This section will be written in Spanish to simplify the correction of this assignment**  

Las primeras modificaciones y las más grandes fueron acerca de la implementacion de Weapon. Inicialmente,
 existia una unica clase Weapon que manejaba los valores asignados a este de peso, ataque, nombre y tipo. Donde 
el tipo se sacaba de una enumeracion definida. Esto lo encontre bastante mal diseñado pues Weapon tenía toda la
responsabilidad como clase, además de que tener una variable de tipo de arma es extraño y la enumeracion no es 
buena practica pues para generar nuevas armas se necesita ir a modificarlo para extender el codigo, además de que
puede haber problemas en como se escribo el tipo del arma al instanciar la clase y otros problemas.  

Para esto se hizo toda una jerarquizacion de clases. Primero se hicieron 5 clases, una para cada una de las armas.
Cada arma ahora sabe cuál es su tipo, pues están definidas como objetos tangibles como una espada, un arco, etc...
 Por esto se eliminó la variable type de Weapon. En el caso del Staff, esta extiende de una clase abstracta 
AbstractMagicWeapon que implementa la interfaz MagicWeapon. Esto podria pensarse que es engorroso porque solo staff
 debe contener el parametro magicDamage, sin embargo, en caso de que se quiera extender el codigo y agregar más armas con
 daño magico ahora sería muy simple, pues solo deberian heredar de tal clase abstracta y heredaran el comportamiento 
que deben tener las armas magias.  

Luego, todas las armas junto con la clase abstracta AbstractMagicWeapon heredan de otra clase abstracta AbstractWeapon.
 Esto es para agrupar el comportamiento comun que tienen todas las armas y obligar a que cada arma tenga el comportamiento 
esperado. Además de implemento la interfaz Weapon a tal clase abstracta para poder utilizar como tipo a Weapon y también de 
firmar un contrato de que metodos debe tener Weapon.  

Por último, AbstractWeapon hereda de AbstractItem que a su vez implementa la interfaz Item. Este diseño puede ser 
innecesario de momento, pues actualmente los unicos objetos son Weapons segun el enunciado. Pero en caso de que se
 quieran implementar nuevos objetos, como es el caso de pociones, armamento o consumibles en general (elementos muy comunes en juegos RPG),
esta implementacion permite tener centralizado el comportamiento de un objeto y hace facil la 
extension del codigo a futuro. De esta manera se consideró que un Item simplemente tiene un nombre y un peso.  

Por último respecto a las armas, la interfaz MagicWeapon extiende de Weapon y Weapon a su vez extiende de Item. 
Esto se hizó simplemente con la idea de refozar la idea de que "Una arma magica es a su vez un arma" o también que 
"Un arma es a su vez un objeto". Igualmente, cada subclase de las clases que implementan estas interfaces están heredando 
los metodos de tal interfaz porque necesariamente el padre debe de haber implementado ese metodo, o bien haber dejado 
la responsabilidad a los hijos de realizar tal implementacion. Respecto a las redundancias que esto puede generar, 
notese que cada clase abstracta e interfaz tiene metodos diferentes por lo que no existiran problemas por colisiones 
por el problema del "diamante" (el cual seria que haya colisiones de un metodo que se llame igual y tenga misma firma).  

Se agregaron metodos equals, hashcode y toString a todas las armas también.

En este sentido, la idea general del diseño del proyecto, es dejar que los objetos tangibles como armas o personajes 
sean clases concretas, mientras que abstracciones o calificaciones de estos objetos son clases abstractas para 
evitar que se instancien cosas como "un arma" o "un personaje del juego" los cuales no es algo concreto sino más 
bien una abstraccion de lo que sería una espada o un mago.  

#### Respecto a characters:  

En primer lugar, se abstrajo el comportamiento común en ambos magos en una clase abstraca AbstractMageCharacter y
 una interfaz MageCharacter que obliga a implementar setters y getters para el Mp. De esta manera se generaliza el 
comportamiento de estos personajes y se centraliza en tal clase abstracta, lo cual también permite extender el 
codigo a futuro.  

Luego, también se consideró que 2 instancias de una clase deben tener currentHp y currentMp iguales para considerarse 
como lo mismo en el metodo equals. Asi que se agregó tal condicion a todos los equals donde correspondia.  

Se modificó Enemy para que ahora tenga también el parametro ataque, pues por enunciado este debiese estar definido. 
También se creó un getter para tal metodo y se modificó equals, hashcode y toString para que lo incluya.  

El metodo waitTurn() se modificó también. Esto debido a que era dificilmente extendible y usaba instanceof lo cual
 no es bueno. Para ello se implementó el metodo getWeight() general para todos los GameCharacters. El problema era 
que AbstractGameCharacter no podía saber como implementar tal metodo, por lo que se declaró abstracto y se le dejó 
tal responsabilidad a sus subclases. En el caso de enemy, este ya tiene un getter para obtener tal valor, sin embargo, 
en el caso de un AbstractPlayerCharacter no tienen un peso. Para esto se implementó getWeight() como simplemente 
obtener el peso del arma que tienen equipada. 
De esta manera ahora se puede generalizar el comportamiento y evitar el uso de instanceof, haciendo más extendible el codigo 
y dejando a las subclases la responsabilidad de saber cuál es su propio peso.  

Estas fueron las modificaciones más importantes, también existieron otras menores en la visibilidad de parametros, 
como por ejemplo que los constructores de clases abstractas están protected pues solo serían llamadas por sus subclases. 
También muchos parametros tanto de armas como de personajes se declararón final, pues no tendria mucho sentido modificar 
sus valores.  

Para terminar, solo queria decirle a quien esté leyendo esto que tenga un buen dia <3