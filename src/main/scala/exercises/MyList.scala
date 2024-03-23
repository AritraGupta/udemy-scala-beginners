package exercises

abstract class MyList[+A] {

  /*
      Singly Linked List which holds integers
      head = return an Int which is the first element of the list
      tail = remainder of the list
      isEmpty = boolean -> is this list empty
      add(int) = new list with this element added
      toString = a string representation of the list
   */

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](item: B): MyList[B]
  def printElements: String
  override def toString: String   = s"[ $printElements ]"

  def map[B](transformer: MyTransformer[A,B]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]
  def flatMap[B](transformer: MyTransformer[A,MyList[B]]): MyList[B]

  //concatenation
  def ++[B >: A](list: MyList[B]): MyList[B]

}

object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](item: B): MyList[B] = new nonEmpty(item,Empty)

  override def printElements: String = ""

  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty
  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

}

class nonEmpty[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](item: B): MyList[B] = new nonEmpty[B](item,this)

  override def printElements: String =
    if (t.isEmpty) s"$h"
    else s"$h ${t.printElements}"

  def map[B](transformer: MyTransformer[A,B]): MyList[B] = {
    new nonEmpty(transformer.transform(h),t.map(transformer))
  }
  /*
  [1,2,3].map(element * 2) =
  new nonEmpty(2, [2,3].map(element*2)
  new nonEmpty(2, new nonEmpty(4,[3].map(element * 2)
  new nonEmpty(2, new nonEmpty(4, new nonEmpty(6, Empty.map(element * 2)
  new nonEmpty(2, new nonEmpty(4, new nonEmpty(6, Empty)
   */

  def filter(predicate: MyPredicate[A]): MyList[A] = {
    if (predicate.test(h)) new nonEmpty(h,t.filter(predicate))
    else t.filter(predicate)
  }

  /*
  [1,2,3].filter(n % 2 == 0) =
  [2,3].filter(n % 2 == 0) =
  new nonEmpty(2,3.filter(n % 2 == 0)) =
  new nonEmpty(2,Empty.filter(n % 2 == 0) =
  new nonEmpty(2,Empty)
   */
  /*
  def flatMap[B](transformer: MyTransformer[A, B]): MyList[B] =
    new nonEmpty(transformer.transform(h), t.flatMap(transformer))
  */
  /*
  [1,2] ++ [3,4]
  new nonEmpty(1, [2] ++ [3,4])
  new nonEmpty(1, new nonEmpty(2, Empty ++ [3,4]))
  new nonEmpty(1, new nonEmpty(2, new nonEmpty(3, new nonEmpty(4, Empty))))
   */
  def ++[B >: A](list: MyList[B]): MyList[B] = new nonEmpty(h, t ++ list)

  /*
  [1,2].flatMap(n => [n,n*2])
  [1,2] ++ [2].flatMap(n => [n,n*2])
  [1,2] ++ [2,4] ++ Empty.flatMap(n => [n,n*2])
  [1,2] ++ [2,4] ++ Empty
  [1,2,2,4]

   */

  def flatMap[B](transformer: MyTransformer[A,MyList[B]]): MyList[B] =
    transformer.transform(h) ++ t.flatMap(transformer)
}

trait MyPredicate[-T] {
  def test(element:T): Boolean
}

trait MyTransformer[-A,B] {
  def transform(element:A): B
}

object listTest extends App {

  val listOfIntegers = new nonEmpty(1,nonEmpty(2,nonEmpty(3,Empty)))
  val anotherListOfIntegers = new nonEmpty(4,nonEmpty(5,Empty))
  val listOfStrings = new nonEmpty("Hello", nonEmpty("I", nonEmpty("am",nonEmpty("Aritra",Empty))))
  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  println(listOfIntegers.map(new MyTransformer[Int,Int]{
     override def transform(element: Int): Int = element * 2
  }).toString)

  println(listOfIntegers.filter(new MyPredicate[Int]{
    override def test(element: Int): Boolean = element % 2 == 0
  }).toString)

  println(listOfIntegers ++ anotherListOfIntegers)

  println(listOfIntegers.flatMap(new MyTransformer[Int,MyList[Int]]{
    override def transform(element: Int) = new nonEmpty(element,new nonEmpty(element*2,Empty))
  }).toString)

  //val list = new nonEmpty(1,nonEmpty(2,nonEmpty(3,Empty)))
  /*println(list.head)
  println(list.tail.head)
  println(list.add(4).head)
  println(list.isEmpty)
  println(list.toString)
*/
  /*
  val list1 = Empty
  println(list1.isEmpty)
  println(list1.toString)
  val list2=list1.add(10)
  println(list2.head)
  println(list2.tail)
  val list3 = list2.add(20)
  println(list3.toString)
  println(list3.tail)
  val list4 = list3.add(30)
  println(list4.tail) //println automatically calls the toString method of the object being called
*/
}


/*
abstract class MyList {

  /*
      Singly Linked List which holds integers
      head = return an Int which is the first element of the list
      tail = remainder of the list
      isEmpty = boolean -> is this list empty
      add(int) = new list with this element added
      toString = a string representation of the list
   */

  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(item: Int): MyList
  def printElements: String
  override def toString: String   = s"[ $printElements ]"

}

object Empty extends MyList {
  def head: Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(item: Int): MyList = new nonEmpty(item,Empty)

  override def printElements: String = ""
}

class nonEmpty(h: Int, t: MyList) extends MyList {
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(item: Int): MyList = new nonEmpty(item,this)

  override def printElements: String =
    if (t.isEmpty) s"$h"
    else s"$h ${t.printElements}"

}

object listTest extends App {
  val list = new nonEmpty(1,nonEmpty(2,nonEmpty(3,Empty)))
  /*println(list.head)
  println(list.tail.head)
  println(list.add(4).head)
  println(list.isEmpty)
  println(list.toString)
*/
  val list1 = Empty
  println(list1.isEmpty)
  println(list1.toString)
  val list2=list1.add(10)
  println(list2.head)
  println(list2.tail)
  val list3 = list2.add(20)
  println(list3.toString)
  println(list3.tail)
  val list4 = list3.add(30)
  println(list4.tail) //println automatically calls the toString method of the object being called

}
 */
