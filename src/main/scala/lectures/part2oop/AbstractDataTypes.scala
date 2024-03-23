package lectures.part2oop

object AbstractDataTypes extends App {

  //abstract
  abstract class Animal {
    val creatureType: String = "wild"
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "canine" //override keyword is optional
    def eat: Unit = println("crunch crunch")
  }

  //traits
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredFood: String = "fresh meat"
  }

  trait coldBlooded

  class Crocodile extends Animal with Carnivore with coldBlooded {
    override val creatureType: String = "croc"
    def eat: Unit = println("nonnom")
    def eat(animal: Animal): Unit = println(s"I am a croc and I am eating a ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc eat dog

}
