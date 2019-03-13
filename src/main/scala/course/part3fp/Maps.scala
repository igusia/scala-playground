package course.part3fp

object Maps extends App {

  val list = List(1, 2, 3)
  println(list)

  println(list.head)
  println(list.tail)

  println(list.map(_ + 1))

  println(list.filter(_ % 2 == 0))

  val toPair: Int => List[Int] = (x: Int) => List(x, x + 1)

  println(list.flatMap(toPair))

  val chars = List('a', 'b', 'c')
  val numbers = List(1, 2, 3)

  val mapCharsNumbers: (Char, List[Int]) => List[String] = (x: Char, y: List[Int]) => y.map(x + "" + _)

  println(chars.flatMap(mapCharsNumbers(_, numbers)))
  

}
