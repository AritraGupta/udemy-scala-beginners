package lectures.part2oop

object OOBasics extends App{

  val person = new Person("David", 5)
  println(person.x)
  person.greet("John")
  person.greet()

  val person2 = new Person("Kate")
  println(person2.age)

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(imposter))

  val counter = new Counter()
  counter.print
  counter.increment.print
  counter.increment.increment.print
  counter.increment(5).print


}

class Person(name: String, val age: Int = 10) {

  val x = 2 //member

  println(1 + 3)

  def greet(name: String): Unit = println(s"${this.name} says, Hi $name")
  def greet(): Unit = println(s"Hi $name")
  //method overloading. this keyword to specify member of this class

  //def this(name: String) = this(name,0)
}


/*

Novel and Writer

Writer : firstname, surname, year
- method - fullname


Novel: name, year of release, author
- authorAge : returns age of author at the year of release
- isWrittenBy(author)
- copy(new year of release) = returns new instance of Novel with the new release year


 */


class Writer(val firstname: String, val surname: String, val yearOfBirth: Int) {
  def fullName: String = firstname + " " + surname
}

class Novel(name: String, yearOfRelease: Int, author: Writer){
  def authorAge : Int = yearOfRelease - author.yearOfBirth
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newYearOfRelease: Int) : Novel = new Novel(name, newYearOfRelease, author)

}

/*
Counter class
- receives an int value
- returns a current count
- method to increment/decrement count by 1 => return a new Counter
- overload the increment/decrement methods to receive a paramter
 */

class Counter(val counter: Int = 0){
  //def currentCount: Int = counter
  def increment: Counter = {
    println("incrementing")
    new Counter(this.counter+1)
  } //immutability
  def decrement: Counter = {
    println("decrementing")
    new Counter(this.counter-1)
  }
  def increment(byValue: Int): Counter = {
    if (byValue <= 0) this
    else increment.increment(byValue-1)
  }
  def decrement(byValue: Int): Counter = {
    if (byValue <= 0) this
    else decrement.decrement(byValue-1)
  }

  def print = println(counter)
}