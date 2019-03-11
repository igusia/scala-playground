package exercises

abstract class ListImplementation[+A] {
  
  def head: A
  def tail: ListImplementation[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): ListImplementation[B]

  def map[B](transformer: Transformer[A, B]): ListImplementation[B]
  def filter(predicate: Predicate[A]): ListImplementation[A]
  def flatMap[B](transformer: Transformer[A, ListImplementation[B]]): ListImplementation[B]

  def printElements: String
  override def toString: String = "[" + printElements + "]"

  def ++[B >: A](list: ListImplementation[B]): ListImplementation[B]
}

trait Predicate[-T] {
  def test(value: T): Boolean
}

trait Transformer[-A, B] {
  def transform(value: A): B
}

object Empty extends ListImplementation[Nothing] {
  def head = throw new NoSuchElementException
  def tail: ListImplementation[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): ListImplementation[B] = new NonEmpty(element, Empty)
  def printElements: String = ""

  def map[B](transformer: Transformer[Nothing, B]): ListImplementation[B] = Empty
  def filter(predicate: Predicate[Nothing]): ListImplementation[Nothing] = Empty
  def flatMap[B](transformer: Transformer[Nothing, ListImplementation[B]]): ListImplementation[B] = Empty

  def ++[B >: Nothing](list: ListImplementation[B]): ListImplementation[B] = list
}

class NonEmpty[+A](h: A, t: ListImplementation[A]) extends ListImplementation[A] {
  def head = h
  def tail: ListImplementation[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): ListImplementation[B] = new NonEmpty(element, this)
  def printElements: String =
    if(t.isEmpty) "" + h
    else h + " " + t.printElements

  def map[B](transformer: Transformer[A, B]): ListImplementation[B] = {
    new NonEmpty(transformer.transform(h), t.map(transformer))
  }

  def filter(predicate: Predicate[A]): ListImplementation[A] = {
    if(predicate.test(h)) new NonEmpty(h, t.filter(predicate))
    else t.filter(predicate)
  }

  def ++[B >: A](list: ListImplementation[B]): ListImplementation[B] = new NonEmpty[B](h, t ++ list)

  def flatMap[B](transformer: Transformer[A, ListImplementation[B]]): ListImplementation[B] = {
    transformer.transform(h) ++ t.flatMap(transformer)
  }
}

object ListTest extends App {
  // Empty is an object - it has only 1 reference and acts as a singleton
  val list = new NonEmpty[Int](1, Empty)
  println(list.head)
  val newList = list.add(4)
  println(newList.toString)

  val listString = new NonEmpty[String]("test", Empty)
  println(listString.toString)

  val listIntegers: ListImplementation[Int] = new NonEmpty[Int](4, Empty)

  println(listIntegers.map(new Transformer[Int, Int] {
    override def transform(value: Int): Int = value * 2
  }))

  println(listIntegers.filter(new Predicate[Int] {
    override def test(value: Int): Boolean = value % 2 == 0
  }))

  println(listIntegers.flatMap(new Transformer[Int, ListImplementation[Int]] {
    override def transform(value: Int): ListImplementation[Int] = new NonEmpty[Int](value, new NonEmpty[Int](value + 1, Empty))
  }))

}