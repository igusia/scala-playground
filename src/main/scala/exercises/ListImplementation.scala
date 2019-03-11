package exercises

abstract class ListImplementation {

  /*
     singly linked list
     head = returns first element
     tail = remainder of the list
     isEmpty = boolean
     add(int) => new list with this element added
     toString => a string representation
   */

  def head: Int
  def tail: ListImplementation
  def isEmpty: Boolean
  def add(element: Int): ListImplementation

  def printElements: String
  override def toString: String = "[" + printElements + "]"

}

object Empty extends ListImplementation {
  def head: Int = throw new NoSuchElementException
  def tail: ListImplementation = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(element: Int): ListImplementation = new NonEmpty(element, Empty)
  def printElements: String = ""
}

class NonEmpty(h: Int, t: ListImplementation) extends ListImplementation {
  def head = h
  def tail: ListImplementation = t
  def isEmpty: Boolean = false
  def add(element: Int): ListImplementation = new NonEmpty(element, this)
  def printElements: String =
    if(t.isEmpty) "" + h
    else h + " " + t.printElements

}

object ListTest extends App {
  // Empty is an object - it has only 1 reference and acts as a singleton
  val list = new NonEmpty(1, Empty)
  println(list.head)
  val newList = list.add(4)
  print(newList.toString)
}