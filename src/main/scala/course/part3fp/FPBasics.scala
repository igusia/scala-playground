package course.part3fp

object FPBasics extends App {

  trait changer[A, B] {
    def apply(element: A): B
  }

  val doubler = new changer[Int, Int] {
    def apply(element: Int) = element * 2
  }

  println(doubler(2))

  val stringToIntConverter: (String => Int) = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("3"))

  // Function2 ((Int, Int) => Int)

  val stringConcatenator = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  println(stringConcatenator("hello", "scala"))

  val inceptionFunction = new Function1[Int, Function1[Int, Int]] {
    override def apply(v1: Int): Function1[Int, Int] = new Function[Int, Int] {
      override def apply(v2: Int): Int = v1 + v2
    }
  }

  println(inceptionFunction(5)(3)) // curried function

}
