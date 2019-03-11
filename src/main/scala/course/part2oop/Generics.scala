package course.part2oop

object Generics extends App {

  // generics also work for traits

  class ListImplementation[+A] {
    // if we add a dog (animal) to a list of cats, we will get a list of animals
    def add[B >: A](element: B): ListImplementation[B] = ???

  }

  val listOfInts = new ListImplementation[Int]
  val listOfString = new ListImplementation[String]

  // generics - methods
  object ListImplementation {
    def empty[A]: ListImplementation[A] = ???
  }

  val emptyListOfIntegers = ListImplementation.empty[Int]

  // variance problem
  class Animal
  class Dog extends Animal
  class Cat extends Animal

  // List[Cat] extends List[Animal] = covariance (+)
  class CovariantList[+A]
  val animalList: CovariantList[Animal] = new CovariantList[Cat] // can we add dogs? not so simple...

  // invariance
  class InvariantList[A]
  val invariantList: InvariantList[Animal] = new InvariantList[Animal] // InvariantList[Cat] will not work

  // contravariance
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  // only subtypes of Animal
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

}
