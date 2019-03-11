package course.part2oop

object Exceptions extends App {

  val x: String = null
  // println(x.length)
  // throwing returns Nothing

  // val aWeirdValue = throw new NullPointerException
  // throwable classes extend the Throwable class
  // main Throwable subtypes are Exceptions and Errors

  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42

  val potentialFail = try {
    getInt(true)
  } catch {
    case e: RuntimeException => println("caught a Runtime exception")
  } finally {
    // executes no matter what, does not influence the return type
    println("finally")
  }

  println(potentialFail) // unit

  class customException extends Exception
  val exception = new customException

  // throw exception
  try {
    val array = Array.ofDim(Int.MaxValue)
  } catch {
    case e: OutOfMemoryError => println(Int.MaxValue + " " + "exceeds allowed limit")
  }
}
