package com.OOP

object MethodNotations extends App {
  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person) =
      s"${this.name} is hanging out with ${person.name}"
    def unary_! = s"my name is $name"
    def unary_+ = new Person(name, favoriteMovie, age + 1)
    def isAlive = true
    def apply(time: Int = 0) = s"Hi, my name is $name and I like $favoriteMovie $time"
    def +(nickName: String): Person =
      new Person(s"$name ($nickName)", favoriteMovie)
    def learns(subject: String) = s"Mary learns $subject"
    def learnsScala = this learns "Scala"

  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  print(mary likes "inception")
  // infix notation = operator notation (syntactic sugar)

  // "operator" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary hangOutWith tom)

  // all operator is method
  println(1 + 2)
  println(1.+(2))

  // prefix notation
  val x = -1
  val y = 1.unary_-
  // unary_prefix only works with - + ~ !

  println(!mary)

  // postfix notation
  println(mary.isAlive)

  // apply op -> fp
  println(mary.apply())
  println(mary())

  println((mary + "the rockstar")())
  println((+mary).age)
  println(mary learns "scala")
}
