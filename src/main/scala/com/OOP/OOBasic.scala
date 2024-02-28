package com.OOP

import java.util.Date

object OOBasic extends App {
  val person = new Person("John", 26)

  println(person.greet("Json"))

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectation", 1861, author)

  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(imposter))
  
  val counter = new Counter
  println(counter.count)
  counter.inc
  println(counter.inc.inc.count)
  println(counter.count)

}

class Person(name: String, val age: Int) {
  // method
  def greet(name: String): Unit = println(s"my name ${this.name}, Hi say $name")

  // overloading
  def greet(): Unit = println(s"Hi my name is ${this.name}")

  // multiple constructor [not freq used]
  def this(name: String) = this(name, 0)
}

class Writer(firstName: String, surname: String, val year: Int) {
  def fullName: String = s"$firstName $surname"
}

class Novel(name: String, year: Int, author: Writer) {
  def authorAge = year - author.year
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}

// immutability
class Counter(val count: Int = 0) {
  def inc = {
    println("incrementing")
    new Counter(count + 1)
  }
  def dec = {
    println("decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = 
    if (n <= 0) this
    else inc.inc(n-1)
  
  def dec(n: Int): Counter =
    if (n <= 0) this
    else dec.dec(n-1)
}
