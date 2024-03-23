package lectures.part2oop

object Generics extends App{

  class MyList[A] //generic class

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  class MyMap[key, Value]

  //generic methods
  object MyList{
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  //variance
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  //Q: Since Cat extends Animal, does a List[Cat] extend List[Animal]

  //1: Yes = COVARIANCE
  class CovariantList[+A]
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  //2. No = INVARIANCE
  class InvariantList[A]
  val invariantList: InvariantList[Animal] = new InvariantList[Animal]

  //3. Hell No = CONTRAVARIANCE
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]



}
