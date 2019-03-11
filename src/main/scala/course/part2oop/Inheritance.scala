package course.part2oop

object Inheritance extends App {

  // single class inheritance
  sealed class Animal {
    val creatureType = "wild"
    def eat = println("nomnom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  // constructor Person with no parameters does not exist
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  class Dog(dogType: String) extends Animal {
    override def eat = {
      super.eat
      println("crunch, crunch")
    }
    override val creatureType: String = dogType
  }

  val dog = new Dog("domestic")
  dog.eat
  println(dog.creatureType)

  // type substitution
  val unknownAnimal: Animal = new Dog("domestic")

  unknownAnimal.eat

  // final field/method can't be overriden
  // final class - other classes cannot extend this class
  // seal the class - only class in THIS class can extend this class

}
