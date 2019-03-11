package course.part2oop

object AbstractDataTypes extends App {

  // abstract classes have abstract (non-implemented) members
  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    // override is not mandatory for abstract members
    val creatureType: String = "domestic"
    override def eat: Unit = println("crunch")
  }

  // traits have abstract members but unlike abstract classes can be extended (multiple traits)s along with classes
  trait Carnivore {
    def eat(animal: Animal): Unit
    val prefferedMeal: String = "meat"
  }

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "croc"
    def eat: Unit = println("nomnomnom")
    def eat(animal: Animal) = println(s"I am a croc and I'm eating ${animal.creatureType} animal")
  }

  val dog = new Dog
  val crocodile = new Crocodile
  crocodile.eat(dog)

  // abstract classes can have abstract and non-abstract members (both) and so can traits!
  // traits do not have constructor parameters
  // you can extend one (abstract class) but multiple traits
  // traits = behaviour (what they do), abstract class = thing (what is it)

}
