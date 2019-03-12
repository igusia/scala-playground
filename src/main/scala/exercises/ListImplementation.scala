package exercises

abstract class ListImplementation[+A] {

  def head: A
  def tail: ListImplementation[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): ListImplementation[B]

  // higher-order functions
  def map[B](transformer: A => B): ListImplementation[B]
  def filter(predicate: A => Boolean): ListImplementation[A]
  def flatMap[B](transformer: A => ListImplementation[B]): ListImplementation[B]

  def printElements: String
  override def toString: String = "[" + printElements + "]"

  def ++[B >: A](list: ListImplementation[B]): ListImplementation[B]

  def foreach(func: A => Unit)
  def sort(sorting: (A, A) => Int): ListImplementation[A]

  def zipWith[B, C](list: ListImplementation[B], zip: (A, B) => C): ListImplementation[C]
  def fold[B](start: B)(operator: (B, A) => B) : B

}

case object Empty extends ListImplementation[Nothing] {
  def head = throw new NoSuchElementException
  def tail: ListImplementation[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): ListImplementation[B] = NonEmpty(element, Empty)
  def printElements: String = ""

  def map[B](transformer: Nothing => B): ListImplementation[B] = Empty
  def filter(predicate: Nothing => Boolean): ListImplementation[Nothing] = Empty
  def flatMap[B](transformer: Nothing => ListImplementation[B]): ListImplementation[B] = Empty

  def ++[B >: Nothing](list: ListImplementation[B]): ListImplementation[B] = list

  def foreach(func: Nothing => Unit) = ()

  def sort(sorting: (Nothing, Nothing) => Int): ListImplementation[Nothing] = Empty

  def zipWith[B, C](list: ListImplementation[B], zip: (Nothing, B) => C) = {
    if (!list.isEmpty) throw new RuntimeException("non-empty list")
    else Empty
  }
  def fold[B](start: B)(operator: (B, Nothing) => B) : B = start

}

case class NonEmpty[+A](h: A, t: ListImplementation[A]) extends ListImplementation[A] {
  def head = h
  def tail: ListImplementation[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): ListImplementation[B] = NonEmpty(element, this)
  def printElements: String =
    if(t.isEmpty) "" + h
    else h + " " + t.printElements

  def map[B](transformer: A => B): ListImplementation[B] = {
    NonEmpty(transformer(h), t.map(transformer))
  }

  def filter(predicate: A => Boolean): ListImplementation[A] = {
    if(predicate(h)) NonEmpty(h, t.filter(predicate))
    else t.filter(predicate)
  }

  def ++[B >: A](list: ListImplementation[B]): ListImplementation[B] = NonEmpty[B](h, t ++ list)

  def flatMap[B](transformer: A => ListImplementation[B]): ListImplementation[B] = {
    transformer(h) ++ t.flatMap(transformer)
  }

  def foreach(func: A => Unit)= {
    func(h)
    t.foreach(func)
  }

  def sort(sorting: (A, A) => Int): ListImplementation[A] = {
    def insert(x: A, sortedList: ListImplementation[A]): ListImplementation[A] = {
      if (sortedList.isEmpty) NonEmpty(x, Empty)
      else if (sorting(x, sortedList.head) < 0) NonEmpty(x, sortedList)
      else NonEmpty(sortedList.head, insert(x, sortedList.tail))
    }
    val sortedTail = t.sort(sorting)
    insert(h, sortedTail)
  }

  def zipWith[B, C](list: ListImplementation[B], zip: (A, B) => C): ListImplementation[C] = {
    if (list.isEmpty) throw new RuntimeException("lists do not have the same length")
    else NonEmpty(zip(h, list.head), t.zipWith(list.tail, zip))
  }

  def fold[B](start: B)(operator: (B, A) => B): B = {
    t.fold(operator(start, h))(operator)
  }
}

object ListTest extends App {
  // Empty is an object - it has only 1 reference and acts as a singleton
  val list = NonEmpty[Int](1, Empty)
  println(list.head)
  val newList = list.add(4)
  println(newList.toString)

  val listString = NonEmpty[String]("test", Empty)
  println(listString.toString)

  val listIntegers: ListImplementation[Int] = NonEmpty[Int](4, Empty)

  println(listIntegers.map(_ * 2))
  println(listIntegers.filter(_ % 2 == 0))

  println(listIntegers.flatMap(x => NonEmpty(x, NonEmpty(x + 1, Empty))))

  listIntegers.foreach(println)

  val listInts = NonEmpty(1, NonEmpty(0, NonEmpty(5, NonEmpty(2, Empty))))
  println(listInts.sort((x: Int, y: Int) => y - x))
  val listToZip = NonEmpty(3, NonEmpty(2, NonEmpty(1, NonEmpty(4, Empty))))
  println(listInts.zipWith[Int, Int](listToZip, (x, y) => x + y))

  println(listInts.fold[Int](0)(_ + _))
  println(listInts.fold[Int](1)(_ * _))

}