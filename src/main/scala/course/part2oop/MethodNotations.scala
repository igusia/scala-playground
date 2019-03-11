package course.part2oop

object MethodNotations extends App {

 class Person(val name: String, movie: String, val age: Int = 0) {
  def likes(movie: String): Boolean = movie == this.movie
  def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
  def unary_! : String = s"$name, what the heck?!"
  def isAlive: Boolean = true
  def apply(): String = s"Hi, my name is $name and I like $movie"

  def unary_+ : Person = new Person(name, movie, age + 1)
  def +(s: String) : Person = new Person(s"$name ($s)", movie, age)
  def learns(s: String): String = s"$name learns $s"
  def learnsScala = learns("Scala")
  def apply(x: Int) : String = s"$name watched $movie $x times"

 }

 val mary = new Person("Mary", "Inception")
 println(mary.likes("Inception"))
 println(mary likes "Inception") // equivalent

 val tom = new Person("Tom", "Fight Club")
 println(mary hangOutWith tom)

 // Akka actors have ! ? methods => all operators ARE methods in Scala

 val x = -1 // equivalent to 1.unary_-, only with - + ~ !
 println(!mary)

 println(mary isAlive)
 println(mary.isAlive) // equivalent

 // apply
 println(mary.apply())
 println(mary()) // equivalent

 println((+mary).age)
 println((mary + "the rockstar").name)
 println(mary.learns("Haskell"))
 println(mary learnsScala)
 println(mary(2))

}

