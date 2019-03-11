package course.part2oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  // 1. class paramaters are fields
  val jim = new Person("Jim", 34)
  println(jim.name) // works!!

  // 2. sensible toString
  println(jim.toString)
  println(jim) // same effect
  // println(instance) = println(instance.toString)

  // 3. equals and hashCode implemented out of the box
  val jim2 = new Person("Jim", 34)
  println(jim == jim2) // true!
  println(jim.hashCode())
  println(jim2.hashCode())

  // 4. handy copy method
  val jim3 = jim.copy()
  val jim4 = jim.copy(age = 45)

  println(jim4)

  // 5. case classes have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23) // apply method

  // 6. case classes are serializable
  // Akka sends serializable methods

  // 7. case classes have extractor patterns - can be used in pattern matching

  case object UK {
    def name: String = "The UK of GB and NI"
  }

}
