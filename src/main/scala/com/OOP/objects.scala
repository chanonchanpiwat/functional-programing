package com.OOP

object Objects extends App {
  object Person {
    val N_EYES = 2
    def canFly = false
    def apply(mother: Person, father: Person): Person = new Person("Bobbies")
  }

  class Person(val name: String) {}

  println(Person.N_EYES)

  // Scala object = singleton instance
  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john)

  val person1 = Person
  val person2 = Person
  println(person1 == person2)

  val bobies = Person(mary, john)

  // scala applications = Scala object with
  // def main(args: Array[String]): Unit
}
