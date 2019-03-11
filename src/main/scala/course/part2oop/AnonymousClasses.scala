package course.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // anonymous class - first anon class is creted then val is an instance of this class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("haha")
  }

  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi = println(s"Hi, my name is $name, how can I help?")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, my name is Jim")
  }

  // anonymous classes work for both abstract and non-abstract classes (and traits)

}
