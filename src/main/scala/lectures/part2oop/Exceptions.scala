package lectures.part2oop
import java.io.PrintStream

object Exceptions extends App{

  val x: String = null
  //println(x.length)
  //this will crash with NullPointerExeption

  //1. throwing exeptions

  //val aWierdValue = throw new NullPointerException

  //throwable classes extend the Throwable class
  //Exception and Error are the major Throwable subtypes

  //2. how to catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException
    else 42

  val potentialFail = try {
    getInt(true)
    //code that might throw
  } catch {
    //case e: RuntimeException => println("No Int for you!")
    case e: RuntimeException => 43
  } finally {
    println("finally")
    //optional
    //it does not influence the return type of the expression
    //use finally for side effects
  }

  println(potentialFail)

  //3. How to define your own exceptions
  class MyException extends Exception
  val exception = new MyException

  //  throw exception

  /*
  1. crash your program with an OutOfMemoryError
  2. crash your program with a StackOverflowError
  3. pocket calculator
    - add(x,y)
    - subtract(x,y)
    - multiply(x,y)
    - divide(x,y)

  Throw

  OverflowException - if add(x,y) exceeds Int.MAX_VALUE
  UnderflowException - subract(x,y) exceeds Int.MIN_VALUE
  MathCalcucaltionException for division by 0
   */

  //OOM
  //val aString = Array.ofDim[Int](Int.MaxValue)

  //SO
  //def infinite:Int = 1 + infinite
  //val inf = infinite

  class Calculator{
    def add(x:Int, y:Int) =
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result

    def subtract(x:Int, y:Int) =
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result

    def multiply(x:Int, y:Int) =
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result

    def divide(x:Int, y:Int) =
      if (y == 0) throw new MathCalculationException
      else x/y
  }

  class OverflowException extends RuntimeException("Over Flow")

  class UnderflowException extends Exception {
    override def printStackTrace(s: PrintStream): Unit = println("UnderFlowException")
  }

  class MathCalculationException extends RuntimeException("Division by 0")

  /*
  val calc = new Calculator
  try{
    calc.add(-10, Int.MinValue)
  } catch{
    case e: OverflowException => println("OverFlowException")
  }*/

  val calc = new Calculator
  //println(calc.add(-10, Int.MinValue))
  println(calc.add(10,Int.MaxValue ))
  println(calc.divide(10,0))


}
