package part1basics

object StringOps extends App {

  val str: String = "Hello, Scala!"

  println(str.charAt(2))
  println(str.substring(7,11)) // inclusive - exlusive
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.toUpperCase())
  println(str.length)
  println(str.length())

  val aNumberString = "45"
  val aNumber = aNumberString.toInt

  println('a' +: aNumberString :+ 'z') // appending and prepending
  println(str.reverse)
  println(str.take(2))

  // String interpolators
  // S-interpolators
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old"

  println(greeting)

  // F-interpolators
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers a minute" // 2 characters total (minimum), 2 decimals precision
  val mythInt = f"he is only $age%d!" // int required

  println(myth)
  println(mythInt)

  // raw-interpolator
  println("This is a \n newline")
  println(raw"This is a \n newline")

  val escaped = "This is a \n newline"
  println(raw"$escaped")

}
