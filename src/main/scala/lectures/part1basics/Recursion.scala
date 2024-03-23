package lectures.part1basics

import scala.annotation.tailrec
import scala.jdk.Accumulator

object Recursion extends App{
  def factorial(n:Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need the factorial of " + (n-1))
      val result = n * factorial(n -1)
      println("Computed factorial of " + n)

      result
    }
  //println(factorial(10))
  //println(factorial(5000))

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x -1, x * accumulator ) //TAIL RECURSION = use a recursive call as the LAST expression

    factHelper(n,1)
  }

  //println(anotherFactorial(5000))

  //WHEN YOU NEED LOOPS USE TAIL RECURSION
  /*
  1. Concatenate a string n times
  2. IsPrime function
  3. Fibonacci Function
   */

  def concatStrings(inputStr: String, n: Int): String =
    @tailrec
    def concatHelper(x: String, acc : String, counter: BigInt): String =
      if (counter <= 0) acc
      else concatHelper(x, x + acc, counter - 1)

    concatHelper(inputStr,"",n)

  println(concatStrings("abc ",5))

  def IsPrime(n: Int): Boolean =
    @tailrec
    def IsPrimeUntil(t: Int, acc: Boolean): Boolean =
      if (t <= 1) acc
      else IsPrimeUntil(t-1, n%t != 0 && acc)

    IsPrimeUntil(n/2, true)

  println(IsPrime(17))

  /*
  def fibonacci(n: Int): Int =
    def calcFibonacci(x: Int, acc: Int): Int =
      if (x <= 2) 1
      else calcFibonacci(x-1, 1 + acc) + calcFibonacci(x-2, 1 + acc)

    calcFibonacci(n,0)

   */

  def fibonacci(n: Int): Int =
    @tailrec
    def calcFibonacci(x : Int, last: Int,nextLast: Int): Int =
      if (x >= n) last
      else calcFibonacci(x+1,last+nextLast,last)

    if (n <= 2) 1
    else calcFibonacci(2, 1, 1)


  println(fibonacci(5))

  def fibonacciSeries(n: Int): String =
    @tailrec
    def fibSerTailrec(x: Int, outputStr: String): String =
      if (x >= n) outputStr
      else fibSerTailrec(x + 1,  outputStr + " " + fibonacci(x))

    fibSerTailrec(1, "")

  println(fibonacciSeries(8))
}

