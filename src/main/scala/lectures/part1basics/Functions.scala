package lectures.part1basics

object Functions extends App{

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello",3))

  def aParmaterlessFunction(): Int = 42

  println(aParmaterlessFunction())
  //println(aParmaterlessFunction) // works only in Scala2

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n==1) aString
    else aString + aRepeatedFunction(aString,n-1)
  }

  println(aRepeatedFunction("Hello",3))

  //WHEN YOU NEED LOOPS, USE RECURSION.
  //Recursive functions always need return types. Other Functions do not

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallFunction(a: Int, b: Int): Int = a + b

    aSmallFunction(n,n-1)
  }

  /*
  1. A Greeting function (name, age) +> "Hi, my name is $name and I am $age years old
  2. factorial function 1*2*3*...*n
  3. fibonacci function
      f(1) = 1
      f(2) = 1
      f(n) = f(n-1) + f(n-2)
  4. Tests if a number is prime

   */

  def aGreetingFunction(name: String, age: Int): String =
    "Hi, my name is " + name + " and I am " + age + " years old"

  //println(aGreetingFunction("David", 10))

  def factorialFunction(n: Int): Int =
    if (n <= 0) 1
    else n * factorialFunction(n-1)

  //println(factorialFunction(0))

  def fibonacciFunction(n: Int): Int =
    if (n<=2) 1
    else fibonacciFunction(n - 1) + fibonacciFunction(n - 2)

  def fibonacciSeries(n: Int): Unit = {
    if (n > 1) {
      print(fibonacciFunction(n) + ",")
      fibonacciSeries(n-1)
    }
    else {
      print(fibonacciFunction(n) + ".")
    }
  }
  fibonacciSeries(8)
  /*
  n
  8 7                                       6
    6                       5               5               4
    5             4         4       3       4       3       3     1
    4       3     3    1    3   1   1 1     3   1   1 1     1 1
    3   1   1 1   1 1       1 1             1 1
    1 1
   */
  //println(fibonacciFunction(9))

  def primeTest(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2)
  }

  //println(primeTest(9))
}



