package course.part2oop

object OOBasics extends App {

  val person = new Person("John", 26)
  println(person.age)
  person.greet("Daniel")
  person.greet

}

// constructor
// class parameters are not fields!! adding keyword val to create a field
// println(person.name) won't work
class Person(name: String, val age: Int) {

  val x = 2 // field

  def greet(name: String): Unit = println(s"${this.name} says: Hello, $name") // method
  // this can access parameters event there are not fields

  // overloading
  def greet(): Unit = println(s"Hi, I am $name")

  // whole block of code is evaluated during instantiation of the class
  println("this is always executed!")

  // multiple constructors
  def this(name: String) = this(name, 0) // can be easier solved by supplying default parameters in main constructor...
  def this() = this("John Doe")

}
