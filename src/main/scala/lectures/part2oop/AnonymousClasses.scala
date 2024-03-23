package lectures.part2oop

object AnonymousClasses extends App{

  abstract class Animal {
    def eat: Unit
  }

  val funnyAnimal = new Animal{
    def eat: Unit = println("ahahahah")
  }

  println(funnyAnimal.getClass)

  /*

  class AnonymousClasses$$anon$1 extends Animal{
    def eat: Unit = println("ahahahah")
  }
  val funnyAnimal = new AnonymousClasses$$anon$1

   */

  class Person(name: String){
    def sayHi: Unit = println(s"Hi my name is $name, how can I help?")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi my name is Jim, how can I help?")
  }

  println(jim.getClass)

  //We can do on the spot instantiation and override methods using anonymous classes
  //We should implement all abstract fields or methods of the abstract classes or traits in the abstract classes created anonymously


  /*
  1. Create a generic trait MyPredicate[-T] - method to test whether a value of type T passes a condition => Boolean

  2. A generic trait myTransformer[-A,B] - method transform to convert a value to type A to type B

  3. MyList
      - map(myTransformer) => new MyList(of a different Type)
      - filter(myPredicate[T]) => MyList
      - flatMap(transformer from A => myList[B]) => myList[B]

      class EvenPredicate extends MyPredicate[Int] = test passed parameter is even or not
      class StringToIntTransformer extends MyTransformer[String, Int] = transform will change String to Int

      [1,2,3],map(n * 2) = [2,4,6]
      [1,2,3,4].filter(n % 2) = [2,4]
      [1,2,3].flatMap(n => [n,n+1]) => [1,2,2,3,3,4]


   */

}
