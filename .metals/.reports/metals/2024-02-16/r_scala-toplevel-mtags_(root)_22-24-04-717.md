error id: file://<WORKSPACE>/src/main/scala/com/OOP/Generics.scala:[1102..1103) in Input.VirtualFile("file://<WORKSPACE>/src/main/scala/com/OOP/Generics.scala", "package com.OOP

object Generics extends App {
  class MyList[+A] {
    def add[B >: A](element: B): MyList[B] = ???
  }

  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. yes List[Cat] extends List[Animal] = COVARIANCE
  // extended from same class co
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  // 2. NO = INVARIANCE
  // only accept that class
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. NO CONTRAVARIANCE
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

  class Car 
  // val newCage = new Cage(new Car)
}

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def 
}
")
file://<WORKSPACE>/src/main/scala/com/OOP/Generics.scala
file://<WORKSPACE>/src/main/scala/com/OOP/Generics.scala:51: error: expected identifier; obtained rbrace
}
^
#### Short summary: 

expected identifier; obtained rbrace