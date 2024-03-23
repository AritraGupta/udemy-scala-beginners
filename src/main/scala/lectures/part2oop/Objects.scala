package lectures.part2oop

object Objects {

  //SCALA DOES NOT HAVE CLASS LEVEL FUNCTIONALITY ("static")
  def main(args: Array[String]): Unit = {
    object Person { //type - its only instance
      //"static"/"class" level functionality
      val N_EYES = 2

      def canFly: Boolean = false

      //factory method
      //def from(mother: String, father: String): Person = new Person("Bobbie")
      def apply(mother: Person, father: Person): Person = new Person("Bobbie") //better use
    }

    class Person(val name: String) {
      //instance level functionality
    }
    //COMPANIONS


    println(Person.N_EYES)
    println(Person.canFly)

    val person1 = Person
    val person2 = Person

    println(person1 == person2)

    val mary = new Person("Mary")
    val john = new Person("John")

    println(mary == john)

    //val bobbie = Person.from(mary, john)
    //val bobbie = Person.apply(mary, john)
    val bobbie = Person(mary, john)
  }


}
