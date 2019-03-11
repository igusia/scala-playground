package course.part2oop

object Objects {

  // Scala does not have class-level functionality ("static")
  object Person {
    // "static"
    val N_EYES = 2
    // factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  }

  class Person (val name: String) {
    // non-static/instance-level

  }

  // companions can access each other's private members

  def main(args: Array[String]) : Unit = {

  println(Person.N_EYES)

  // Scala object == singleton

  val mary = Person
  val tom = Person // the same instance...
  println(mary == tom)

  val m = new Person("Mary")
  val t = new Person("Tom")
  println(m == t)

  val bobby = Person.apply(m, t)
  val b = Person(m, t) // using factory method

  // Scala applications == Scala object with main
  }

}
