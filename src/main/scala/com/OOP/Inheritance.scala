package com.OOP

object Inheritance extends App {
  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Cat extends Animal {
    override val creatureType = "Feline"
    override def eat: Unit = println("Meow meow")

  }

  val cat = new Cat
  println(cat.creatureType)

  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Crocdile extends Animal with Carnivore {
    val creatureType: String = "Reptile"
    def eat: Unit = println("Tum yum")
    def eat(animal: Animal): Unit = s"I ma a $creatureType and eat ${animal.creatureType}"
  }
}
