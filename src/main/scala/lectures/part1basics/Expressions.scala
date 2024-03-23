package lectures.part1basics

object Expressions extends App{
  val x = 1+ 2
  println(x)

  println(2 + 3 * 4)
  //+ - * / & | ^ << >> >>>(right shift with zero extensions

  println(1 == x)
  println(1 != x)

  //== != > >= < <=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // -+ *= /= ...works with variables (side effects)
  println(aVariable)

  //Instructions vs Expressions
  val aCondition = true
  val aConditionedVariable = if (aCondition) 5 else 3
  println(aConditionedVariable)
  println(if (aCondition) 10 else 3)

  //Everything is Scala is expression. Prefer expressions over imperative programming
  //Side effects are expressions returning Units: println(), while, reassigning variables

  val aWierdVariable = aVariable = 3
  println(aWierdVariable)

  //Code blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }

  println(aCodeBlock)

  val someValue = {
    2 < 3
  }

  val someOtherValue = {
    if (someValue) 238 else 986
    //42
  }

  println(someOtherValue)

  val prn = println("hello world") // expression of type unit
}
