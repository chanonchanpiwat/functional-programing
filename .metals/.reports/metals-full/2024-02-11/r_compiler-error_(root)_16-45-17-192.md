file://<WORKSPACE>/src/main/scala/com/OOP/methodNotations.scala
### scala.reflect.internal.Types$TypeError: illegal cyclic reference involving object Predef

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 2.13.12
Classpath:
<WORKSPACE>/.bloop/root/bloop-bsp-clients-classes/classes-Metals-5_CWDiKZQp-z6ykuyXqrxQ== [exists ], <HOME>/Library/Caches/bloop/semanticdb/com.sourcegraph.semanticdb-javac.0.9.9/semanticdb-javac-0.9.9.jar [exists ], <HOME>/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ]
Options:
-Yrangepos -Xplugin-require:semanticdb


action parameters:
offset: 588
uri: file://<WORKSPACE>/src/main/scala/com/OOP/methodNotations.scala
text:
```scala
package com.OOP

object MethodNotations extends App {
  class Person(val name: String, favoriteMovie: String, age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person) =
      s"${this.name} is hanging out with ${person.name}"
    def unary_! = s"my name is $name"
    def unary_+ = new Person(name, favoriteMovie, age + 1)
    def isAlive = true
    def apply() = s"Hi, my name is $name and I like $favoriteMovie"
    def +(nickName: String): Person = new Person(name + nickName, favoriteMovie)
    def learns(subject: String) = s@@"Mary learns "
    def learnsScala
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
  }

```



#### Error stacktrace:

```

```
#### Short summary: 

scala.reflect.internal.Types$TypeError: illegal cyclic reference involving object Predef