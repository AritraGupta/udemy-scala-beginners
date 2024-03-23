package lectures.part1basics

object StringOps extends App{

  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(7,11))
  println(str.split(" ").toList)
  println(str.startsWith("H"))
  println(str.replace(" ","-"))
  println(str.toLowerCase())
  println(str.length)

  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  val vec = "a" +: aNumberString :+ "z"
  println(vec.getClass) //Vector

  val vec1 = 'a' +: aNumberString :+ 'z'
  println(vec1.getClass) //String

  //Rule of thumb: if you want to prepend/append something, make sure you're appending an element to a collection of elements of that same type. Example: append a character to a String (which is a collection of characters), a number to a list of numbers, etc.

  println(str.reverse)
  println(str.take(2))

  // String Interpolators

  // S-Interpolators

  val name="David"
  val age=12

  val greeting = s"Hello, my name is $name and I am $age years old"
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old"

  println(greeting)
  println(anotherGreeting)

  //F-interpolators

  val speed = 1.2f

  val myth = f"$name can eat $speed%2.2f burgers per minute"
  println(myth)

  // raw-interpolator

  println(raw"This is a \n newline")

  val escaped = "This is a \n newline"
  println(raw"$escaped")

}
