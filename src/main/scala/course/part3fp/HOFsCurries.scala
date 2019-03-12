package course.part3fp

object HOFsCurries extends App {

  // val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = ???
  // higher order function

  // function that applies a function n times over a value x

  // nTimes(f, n, x)
  // nTimes(f, 3, x) = f(f(f(x)))

  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if (n <= 0) x
    else nTimes(f, n-1, f(x))
  }

  val incrementer: Int => Int = x => x + 1
  println(nTimes(incrementer, 5, 2))

  // returning a lambda to use it later
  def nTimesImpr(f: Int => Int, n: Int): Int => Int = {
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesImpr(f, n-1)(f(x))
  }

  println(nTimesImpr(incrementer, 5)(2))

  // curried functions
  val superAdder = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3) // y => 3 + y
  println(add3(10))

  // x can be provided later
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat: Double => String = curriedFormatter("%4.2f")

  println(standardFormat(20))

  def toCurry(f: (Int, Int) => Int): (Int => Int => Int) =
    x => y => f(x, y)

  println(toCurry(_ + _)(2)(3))

  def fromCurry(f: (Int => Int => Int)): (Int, Int) => Int =
    (x, y) => f(x)(y)

  println(fromCurry(x => y => x + y)(2, 3))

  def compose(f: Int => Int, g: Int => Int): Int => Int = {
    x => f(g(x))
  }

  def otherWay(f: Int => Int, g: Int => Int): Int => Int = {
    x => g(f(x))
  }

  println(compose(x => x * 2, y => y + 1)(2))
  println(otherWay(x => x * 2, y => y + 1)(2))
}
