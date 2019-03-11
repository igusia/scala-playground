package course.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int)=
    a + " " + b

  println(aFunction("hello", 1))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  println(aParameterlessFunction) // parameterless functions can be called by its name without parentheses

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("hello", 3))

  // use recursive functions instead of loops!
  // recursive functions must have return types specified

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    aSmallerFunction(n, n - 1)
  }

  /*
    1. A greeting function (name, age) => "Hi, my name is name and I am age years old"
    2. Factorial function 1 * 2 * ... * n
    3. A Fibonacci funcion f(1), f(2), f(n) = f(n - 1), f(n - 2)
    4. Tests if a number is prime.
   */

  def greeting(name: String, age: Int): String =
    "Hi, my name is " + name + " and I am " + age + " years old"

  println(greeting("David", 12))

  def factorial(n: Int): Int = {
    if (n == 1) 1
    else n * factorial(n - 1)
  }

  println(factorial(3))

  def fibonacci(n: Int): Int = {
    if (n == 1 || n == 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  println(fibonacci(9))

  def xIsPrime(x: Int, primeNumber : Int = 2): Boolean = {
    if(primeNumber == x/2) true
    else if (x % primeNumber == 0) false else xIsPrime(x, primeNumber + 1)
  }

  println(xIsPrime(5433591))


}
