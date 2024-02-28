package com.OOP

object InHeritanceTraits extends App {
  class Animal (val creatureType: String = "") {
    def eat = println("yum yu")
  }

  class Cat extends Animal {
    def crunch = this.eat
  }

  val cat = new Cat
  cat.crunch

  class Person(name: String, age: Int = 0)
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  val adult = new Adult("CG", 2, "23")

  class Dog(override val creatureType: String) extends Animal {
    override def eat = { 
      super.eat
      println("Eat dog")}
  }

  val dog = new Dog("K9")
  dog.eat

  // type substitution = polymorphism
  val unknown: Animal = new Dog("K9")
  unknown.eat
}
