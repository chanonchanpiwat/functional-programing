package com.OOP

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

object GenericList extends  App {

  abstract class MyList[+A] {
    def head: A
    def tail: MyList[A]
    def add[B >: A](element: B): MyList[B]
    def isEmpty: Boolean
    def printElements: String
    override def toString(): String = "[" + printElements + "]"
  }

  object Empty extends MyList[Nothing] {
    def head: Nothing = throw new NoSuchElementException
    def tail: MyList[Nothing] = throw new NoSuchElementException
    def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
    def isEmpty: Boolean = true
    def printElements: String = ""
  }

  class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
    def head: A = h
    def tail: MyList[A] = t
    def add[B >: A](element: B): MyList[B] = new Cons(element, this)
    def isEmpty: Boolean = false
    def printElements: String =
      if (t.isEmpty) "" + h else h + " " + t.printElements
  }

  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, Empty)).add(3).add(7)
  println(listOfIntegers)

}
