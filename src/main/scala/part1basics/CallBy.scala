package part1basics

object CallBy extends App {

  def calledByValue(x: Long): Unit = {
    println(x)
    println(x)
  }

  def calledByName(x: => Long): Unit = {
    println(x)
    println(x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())


}
