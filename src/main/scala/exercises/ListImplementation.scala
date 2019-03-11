package exercises

abstract class ListImplementation[+A] {

  /*
     singly linked list
     head = returns first element
     tail = remainder of the list
     isEmpty = boolean
     add(int) => new list with this element added
     toString => a string representation
   */

  def head: A
  def tail: ListImplementation[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): ListImplementation[B]

  def printElements: String
  override def toString: String = "[" + printElements + "]"

}

object Empty extends ListImplementation[Nothing] {
  def head = throw new NoSuchElementException
  def tail: ListImplementation[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): ListImplementation[B] = new NonEmpty(element, Empty)
  def printElements: String = ""
}

class NonEmpty[+A](h: A, t: ListImplementation[A]) extends ListImplementation[A] {
  def head = h
  def tail: ListImplementation[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): ListImplementation[B] = new NonEmpty(element, this)
  def printElements: String =
    if(t.isEmpty) "" + h
    else h + " " + t.printElements

}

object ListTest extends App {
  // Empty is an object - it has only 1 reference and acts as a singleton
  val list = new NonEmpty[Int](1, Empty)
  println(list.head)
  val newList = list.add(4)
  println(newList.toString)

  val listString = new NonEmpty[String]("test", Empty)
  println(listString.toString)
}