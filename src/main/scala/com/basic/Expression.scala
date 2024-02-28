package com.basic

object Expression extends App {
  val x = 1 + 2

  println(2 + 3 * 4)
  println(x)
  println(x == 1)

  var aVariable = 2
  aVariable += 3
  println(aVariable)

  // instruction(do) vs expression(value)
  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3
  println(aConditionedValue)

  // imperative
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  // expression
  val aWeirdValue = (aVariable = 3)
  println(aWeirdValue)

  // Code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (y > z) "y > z" else "z > y"
  }

}
