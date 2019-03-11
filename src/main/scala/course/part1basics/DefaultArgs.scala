package course.part1basics

object DefaultArgs extends App {

  def trFact(n: Int, acc: Int = 1): Int = {
    if (n <= 1) acc
    else trFact(n - 1, n * acc)
  }

  println(trFact(10))

  def savePicture(format: String = "jpg", width: Int, height: Int): Unit = println("saved")

  // this one won't work because of the leading argument
  // savePicture(800, 600)
  savePicture(width = 800, height = 600)
}
