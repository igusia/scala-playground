package course.part3fp

object AnonymousFunctions extends App {

  val doubler = new Function[Int, Int] {
    override def apply(v1: Int): Int = v1 * 2
  }

  println(doubler(6))

  // anonymous function (lambda)
  val fdoubler: Int => Int = x => x * 2

  println(fdoubler(3))

  // multiple params
  val fadder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no params
  val f = () => "bang"

  println(f) // function itself
  println(f()) // must call lambdas with parentheses

  val stringToInt = { str: String =>
    str.toInt
  }

  val niceIncrementer: Int => Int = _ + 1
  val niceAdder: (Int, Int) => Int = _ + _

  val specialAdder = (x: Int) => (y: Int) => x + y

  println(specialAdder(5)(2))
}
