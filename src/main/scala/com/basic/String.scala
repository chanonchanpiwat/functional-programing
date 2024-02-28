package com.basic

object StringOps extends App {
  val str = "Hello, I am learning scala"

  println(str.charAt(2))
  println(str.substring(1, 4))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase)
  println(str.length)

  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println(("a" +: aNumberString :+ "z").toList)
  println(str.reverse)
  println(str.take(2))

  // s-interpolates
  val name = "David"
  val age = 12
  val greeting = s"Hello my name is $name and I am $age"

  // F-interpolator
  val speed = 211.2f
  val myth = f"$name can eat at $speed%2.3f burger per minute"
  println(myth)

  // raw-interpolator
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  println(raw"$escaped")


}
