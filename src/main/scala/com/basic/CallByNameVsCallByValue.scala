package com.basic

object CBNvsCBV extends  App {
  def calledByValue(x: Long): Unit = {
    println("By value: " + x)
    println("By value: " + x)
  }

  def callByName(x: => Long): Unit = {
    println("By name: " + x)
    println("By name: " + x)
  }

  /* 
  def callByName(x: => Long): Unit = {
    println("By name: " + System.nanoTime())
    println("By name: " + System.nanoTime())
  }
   */

   def infinite(): Int = 1+ infinite()
   def printFirst(x: Int, y: => Int) = println(x)

   printFirst(3, infinite())

  calledByValue(System.nanoTime())
  callByName(System.nanoTime())
}