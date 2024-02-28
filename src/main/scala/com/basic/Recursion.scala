package com.basic

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println(
        "Computing factorial of" + n + " - first need factorial of " + (n - 1)
      )
      val result = n * factorial(n - 1)
      println("Computed factorial " + n)
      result

    }

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt = if (x <= 1)
      accumulator
    else factHelper(x - 1, x * accumulator)

    factHelper(n, 1)
  }

  @tailrec
  def concatString(aString: String, accumulator: Int): String = {
    if (accumulator == 1) aString
    else concatString(aString + aString, accumulator - 1)
  }

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeUntil(d: Int, isNotPrime: Boolean): Boolean = if (isNotPrime)
      false
    else if (d <= 1) true
    else isPrimeUntil(d - 1, n % d == 0)

    isPrimeUntil(n / 2, false)
  }

  def fibonacci(n: Int): Int = {
    @tailrec
    def fibonacciTailrec(i: Int, last: Int, nextToLast: Int): Int =
      if (i >= n) last
      else fibonacciTailrec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fibonacciTailrec(2, 1, 1)
  }

  println(fibonacci(8))

}
