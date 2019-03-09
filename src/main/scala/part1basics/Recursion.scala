package part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n)
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)
      result
    }

  println(factorial(10))

  // stack overflow
  // println(factorial(50000))

  def anotherFactorial(n: Int): Int = {
    @tailrec
    def factHelper(x: Int, acc: Int): Int = {
      if (x <= 1) return acc
      else factHelper(x - 1, x * acc)
    }
    factHelper(n, 1)
  }

  println(anotherFactorial(10))

  /*
    1. Concatenating Strings n times tail recursion
    2. IsPrime tail recursion
    3. Fibonacci tail recursion
  */

  def concatenate(string: String, n: Int): String = {
    @tailrec
    def concatHelper(s: String, x: Int, acc: String) : String = {
      if (x <= 0) acc
      else concatHelper(s, x - 1, acc + s)
    }
    concatHelper(string, n, "")
  }

  println(concatenate("hello", 3))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def primeHelper(x: Int, acc: Boolean): Boolean = {
      if (!acc) false
      else if (x <= 1) true
      else primeHelper(x - 1, n % x != 0)
    }
    primeHelper(n/2, true)
  }

  println(isPrime(17389))
  println(isPrime(123456))

  def fibonacci(n: Int): Int = {
    def fibHelper(x: Int, acc: Int, nextacc: Int): Int = {
      if (x == n) acc
      else fibHelper(x + 1, acc + nextacc, acc) // storing last values of fib seq
    }

    if (n <= 2) 1
    else fibHelper(2, 1, 1)
  }

  println(fibonacci(7))

}
