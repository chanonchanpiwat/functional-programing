error id: file://<WORKSPACE>/src/main/scala/com/OOP/AnonymousClass.scala:[268..269) in Input.VirtualFile("file://<WORKSPACE>/src/main/scala/com/OOP/AnonymousClass.scala", "package com.OOP

object AnonymousClass extends App {
  abstract class Animal {
    def eat: Unit
  }

  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("555")
  }

  println(funnyAnimal.getClass())

  class Person(name: String) {
    def
  }
}")
file://<WORKSPACE>/src/main/scala/com/OOP/AnonymousClass.scala
file://<WORKSPACE>/src/main/scala/com/OOP/AnonymousClass.scala:16: error: expected identifier; obtained rbrace
  }
  ^
#### Short summary: 

expected identifier; obtained rbrace