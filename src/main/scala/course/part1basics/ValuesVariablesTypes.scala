package course.part1basics

object ValuesVariablesTypes extends App {

  // values are immutable

  val x: Int = 42
  println(x)

  val y = 42

  val aString: String = "hello"; val anotherString = "goodbye"

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 3242 //2 bytes instead of 4
  val aLong: Long = 433453453234234L //8 bytes instead of 4
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // variables

  var aVariable: Int = 4
  aVariable = 5


}
