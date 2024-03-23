package lectures.part2oop

import playground.{PrinceCharming, Cinderella as Princess}

import java.sql
import java.util.Date
import java.sql.{Date => SqlDate}

//import playground._//{Cinderella, PrinceCharming}



object PackagesAndImports extends App{

  //package members are accessible by their simple name
  val writer = new Writer("Aritra","GreatThings",1994)

  //import package to use other package members
  val princess = new Princess // playground.Cinderella = fully qualified name
  //aliasing can resolve conflicts of classes with same name from different packages

  //packages are hierarchy which match the folder structure

  //package object
  sayHello
  println(SPEED_OF_LIGHT)

  //imports
  val prince = new PrinceCharming

  //1. use FQ name
  //2. use alias
  val date = new Date
  //val sqlDate = new sql.Date(2018,5,4)
  val sqlDate = new SqlDate(2018,5,4)

  //Default Imports
  //java.lang - String, Object, Exception
  //scala - Int, Nothing, Function
  //scala.Predef - println, ???




}
