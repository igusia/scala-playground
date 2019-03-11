package course.part2oop

import exercises.{NonEmpty => SinglyLinkedList, Empty}
// import exercises._

object PackagingAndImports extends App {

  // package members are accessible by their simple name
  val writer = new Writer("Daniel", "D.", 2019)

  // import
  val list = SinglyLinkedList(1, SinglyLinkedList(1, Empty)) // or exercises.NonEmpty
  println(list)

  sayHello

}
