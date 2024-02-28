package com.basic

object Functions extends App {
  def aFunction(a: String, b: Int): String = a + " " + b

  val s = aFunction("hello", 3)

  println(s)

  def aParameterLessFunction(): Int = 43

  println(aParameterLessFunction())
  println(aParameterLessFunction)

  def aRepeatFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatFunction(aString, n - 1)
  }

  println(aRepeatFunction("hello", 3))
  // scala encourage using recursion over loop

  def aFunctionWithSideEffect(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    aSmallerFunction(n, n - 1)
  }

  def greeting(name: String, age: Int): String =
    s"Hi, my name is $name and age is $age"

  def fibonacci(n: Int): Int = {
    if (n <= 1) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = if (t<=1) true else n % t != 0 && isPrimeUntil(t-1)
    isPrimeUntil(n/2)
  }
  println(isPrime(39))
  println(isPrime(51))
}
