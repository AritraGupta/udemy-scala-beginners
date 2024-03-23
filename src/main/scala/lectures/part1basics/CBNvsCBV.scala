package lectures.part1basics

object CBNvsCBV extends App{

  def calledByValue(x : Long): Unit = {
    println("By Value: " + x)
    println("By Value: " + x)
  }
  //calling by value evaluates the parameter first and then passes to the function

  def calledByName(x : => Long) : Unit = {
    println("By Name: " + x)
    println("By Name: " + x)
  }
  //while calling by name the parameter expression is passed everytime and the function evaluates the parameters everytime it is used in the function definition. It is useful in lazy streams and things that may fail.
  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = print(x)

  //printFirst(infinite(), 34)
  printFirst(34,infinite())

}
