package lectures.part2oop

object Inheritance extends App{

  //single class Inheritance
  sealed class Animal{ //adding final keyword on class will prevent its inheritance. sealed keyword prevents this class to be inherited in other files, but can be inherited in this file
    //private def eat = println("nomnom")
    val creatureType = "wild"
    //protected def eat = println("nomnom")
    //final def eat = println("nomnom") -- to prevent overriding
    def eat = println("nomnom")
  }

  class Cat extends Animal{
    def crunch = {
      eat
      println("crunch")
    }
  }

  val cat = new Cat
  //cat.eat
  cat.crunch

  class Person(name: String, age: Int){
    def this(name: String) = this(name, 0)
  }

  //class Adult(name: String, age: Int, idCard: String) extends Person(name, age)
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  //overriding

  class Dog(override val creatureType: String) extends Animal {
    //override val creatureType: String = "domestic"
    override def eat: Unit = {
      super.eat
      println("crunch,crunch")
    }
  }
  //same as
  /*class Dog(dogType: String) extends Animal{
    override val creatureType: String = dogType
  }*/

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)


  //type substitution
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat
}
