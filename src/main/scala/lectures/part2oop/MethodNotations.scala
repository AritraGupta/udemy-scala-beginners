package lectures.part2oop

import language.postfixOps

object MethodNotations extends App{

  class Person(val name: String, val favouriteMovie: String, val age: Int = 0) {
     def likes(movie: String): Boolean = movie == favouriteMovie
     def hangsOutWith(person: Person): String = s"${this.name} hangs out with ${person.name}"
     def +(person: Person): String = s"${this.name} + ${person.name}"
     def unary_! : String = s"$name, What the heck!"
     def isAlive: Boolean = true
     def apply(): String = s"Hi, I am $name and I like $favouriteMovie"
     def unary_+ : Person = new Person(name, favouriteMovie, age+1)
     def learns(subject: String): String = s"$name learns $subject"
     def learnsScala: String = this learns "Scala"
     def apply(num: Int): String = s"$name watched $favouriteMovie $num times"

     //exercises
     def +(nickname: String): Person = new Person(s"$name (the $nickname)", favouriteMovie)


  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") //equivalent
  // infix notation = operator notation. will only work with methods having only one parameter

  val tom = new Person("Tom","Fight Club")
  println(mary hangsOutWith tom)
  println(mary + tom)
  println(mary.+(tom)) //equivalent

  println(1 + 2)
  println(1.+(2)) //equivalent

  //prefix notation
  println(!mary)
  println(mary.unary_!) //equivalent

  println(mary.isAlive)
  println(mary isAlive) // needs explicit import of language.postxfixOps

  println(mary.apply())
  println(mary()) //equivalent

  println((mary + "Rockstar")())
  //val mary1 = +mary
  //println(mary1.age)
  println((+mary).age)

  println(mary learnsScala)

  println(mary(3))

  /*
  1. Overload the + operation which receives a String and return a new Person with a nickname
  mary + "the Rockstar" => new person "Mary (the Rockstar)" and same fav movie

  2. Add an age to the person class with default 0 value.
  add unary + operator => returns a new Person with age + 1

  3.Add a "learns" method in person class, receives string and returns "Mary learns <Param>"
    Add learnsScala doesn't receive any param and calls the learns method in postfix notation

  4.Overload the apply method to receive a number and return a string
    marry.apply(2) => "Marry watched Inception 2 times"




   */

}




