package com.OOP

object AnonymousClass extends App {
  abstract class Animal {
    def eat: Unit
  }

  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("555")
  }

  println(funnyAnimal.getClass())

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi my name is $name")
  }

  val jim = new Person("dop") {
    override def sayHi: Unit = println("HHH")
  }

  println(jim.sayHi)
}