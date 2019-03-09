package part2oop

object OOBasicsExercises extends App {

  val author = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)
  println(novel.authorAge())
  println(novel.isWrittenBy(author))
  val imposter = new Writer("Charles", "Dickens", 1812)
  println(novel.isWrittenBy(imposter)) // false!

  val counter = new Counter(0)
  counter.increment(2).print

}

class Writer(firstName: String, surname: String, val yearOfBirth: Int) {
  def fullName(): String = this.firstName + " " + this.surname
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  def authorAge(): Int = this.yearOfRelease - author.yearOfBirth
  def isWrittenBy(author: Writer): Boolean = author == this.author
  def copy(year: Int) = new Novel(this.name, year, this.author)
}

class Counter(x: Int) {
  def count(): Int = x // getter
  def increment() = new Counter(x + 1) // immutability - new object instead of modifying inside
  def decrement() = new Counter(x - 1)

  def increment(n: Int) = new Counter(x + n)
  def decrement(n: Int) = new Counter(x - n)
  def print = println(x)
}