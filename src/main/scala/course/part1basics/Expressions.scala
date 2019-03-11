package course.part1basics

object Expressions extends App {

  val x = 1 + 2 // expression
  println(x)

  println(2 + 3 * 4)

  println(1 == x)

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // -= *= /=

  // Instructions (DO) vs Expressions (VALUE)
  val aCondition = true
  val aConditionValue = if (aCondition) 5 else 3
  println(aConditionValue)

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  } // never again

  // unit == void
  val aWeirdValue = (aVariable = 3)
  println(aWeirdValue)

  // units: while, reassign, println

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }

  val xIsEven = x%2 == 0
  println(xIsEven)

  val someValue = {
    2 < 3
  }

  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }
}
