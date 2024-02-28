file://<WORKSPACE>/src/main/scala/com/OOP/Generics.scala
### scala.reflect.internal.FatalError: 
  Something is wrong: cannot find A in applied type com.OOP.GenericList.Cons
   sought  A in Cons
 classSym  Cons in GenericList
  tparams  A in Cons

     while compiling: file://<WORKSPACE>/src/main/scala/com/OOP/Generics.scala
        during phase: globalPhase=<no phase>, enteringPhase=parser
     library version: version 2.13.12
    compiler version: version 2.13.12
  reconstructed args: -classpath <WORKSPACE>/.bloop/root/bloop-bsp-clients-classes/classes-Metals-cBZDV2eWR8aRHtKqc_2Y4A==:<HOME>/Library/Caches/bloop/semanticdb/com.sourcegraph.semanticdb-javac.0.9.9/semanticdb-javac-0.9.9.jar:<HOME>/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar -Xplugin-require:semanticdb -Yrangepos -Ymacro-expand:discard -Ycache-plugin-class-loader:last-modified -Ypresentation-any-thread

  last tree to typer: Ident(A)
       tree position: line 50 of file://<WORKSPACE>/src/main/scala/com/OOP/Generics.scala
            tree tpe: A
              symbol: type A in class MyList
   symbol definition: +A (a AbstractTypeSymbol)
      symbol package: com.OOP
       symbol owners: type A -> class MyList -> object GenericList
           call site: <none> in <none>

== Source file context for tree position ==

    47 object GenericList {
    48 
    49   abstract class MyList[+A] {
    50     def head: A
    51     def tail: MyList[A]
    52     def add[B >: A](element: B): MyList[B]
    53     def isEmpty: Boolean

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 2.13.12
Classpath:
<WORKSPACE>/.bloop/root/bloop-bsp-clients-classes/classes-Metals-cBZDV2eWR8aRHtKqc_2Y4A== [exists ], <HOME>/Library/Caches/bloop/semanticdb/com.sourcegraph.semanticdb-javac.0.9.9/semanticdb-javac-0.9.9.jar [exists ], <HOME>/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ]
Options:
-Yrangepos -Xplugin-require:semanticdb


action parameters:
offset: 1959
uri: file://<WORKSPACE>/src/main/scala/com/OOP/Generics.scala
text:
```scala
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

object GenericList {

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

  val listOfIntegers: MyList[Int] = new Cons(1, new Cons@@)

}

```



#### Error stacktrace:

```
scala.reflect.internal.Reporting.abort(Reporting.scala:70)
	scala.reflect.internal.Reporting.abort$(Reporting.scala:66)
	scala.reflect.internal.SymbolTable.abort(SymbolTable.scala:28)
	scala.reflect.internal.tpe.TypeMaps$AsSeenFromMap.correspondingTypeArgument(TypeMaps.scala:531)
	scala.reflect.internal.tpe.TypeMaps$AsSeenFromMap.loop$3(TypeMaps.scala:568)
	scala.reflect.internal.tpe.TypeMaps$AsSeenFromMap.classParameterAsSeen(TypeMaps.scala:573)
	scala.reflect.internal.tpe.TypeMaps$AsSeenFromMap.apply(TypeMaps.scala:446)
	scala.reflect.internal.Types$TypeBounds.mapOver(Types.scala:1576)
	scala.reflect.internal.tpe.TypeMaps$AsSeenFromMap.apply(TypeMaps.scala:447)
	scala.reflect.internal.tpe.TypeMaps$TypeMap.applyToSymbolInfo(TypeMaps.scala:124)
	scala.reflect.internal.tpe.TypeMaps$TypeMap.loop$1(TypeMaps.scala:118)
	scala.reflect.internal.tpe.TypeMaps$TypeMap.firstChangedSymbol(TypeMaps.scala:122)
	scala.reflect.internal.tpe.TypeMaps$TypeMap.mapOver(TypeMaps.scala:136)
	scala.reflect.internal.Types$PolyType.mapOver(Types.scala:3027)
	scala.reflect.internal.tpe.TypeMaps$AsSeenFromMap.apply(TypeMaps.scala:447)
	scala.reflect.internal.Types$Type.asSeenFrom(Types.scala:693)
	scala.reflect.internal.Types$Type.computeMemberType(Types.scala:728)
	scala.reflect.internal.Symbols$MethodSymbol.typeAsMemberOf(Symbols.scala:3085)
	scala.reflect.internal.Types$Type.memberType(Types.scala:719)
	scala.tools.nsc.interactive.Global$Members.$anonfun$add$1(Global.scala:1015)
	scala.tools.nsc.interactive.Global$OnTypeError.onTypeError(Global.scala:1388)
	scala.tools.nsc.interactive.Global$Members.add(Global.scala:1015)
	scala.tools.nsc.interactive.Global.addTypeMember$1(Global.scala:1127)
	scala.tools.nsc.interactive.Global.$anonfun$typeMembers$6(Global.scala:1161)
	scala.tools.nsc.interactive.Global.$anonfun$typeMembers$6$adapted(Global.scala:1160)
	scala.reflect.internal.Scopes$Scope.foreach(Scopes.scala:455)
	scala.tools.nsc.interactive.Global.typeMembers(Global.scala:1160)
	scala.tools.nsc.interactive.Global.typeCompletions$1(Global.scala:1240)
	scala.tools.nsc.interactive.Global.completionsAt(Global.scala:1283)
	scala.meta.internal.pc.SignatureHelpProvider.$anonfun$treeSymbol$1(SignatureHelpProvider.scala:390)
	scala.Option.map(Option.scala:242)
	scala.meta.internal.pc.SignatureHelpProvider.treeSymbol(SignatureHelpProvider.scala:388)
	scala.meta.internal.pc.SignatureHelpProvider$MethodCall$.unapply(SignatureHelpProvider.scala:205)
	scala.meta.internal.pc.SignatureHelpProvider$MethodCallTraverser.visit(SignatureHelpProvider.scala:316)
	scala.meta.internal.pc.SignatureHelpProvider$MethodCallTraverser.traverse(SignatureHelpProvider.scala:310)
	scala.meta.internal.pc.SignatureHelpProvider$MethodCallTraverser.$anonfun$visit$5(SignatureHelpProvider.scala:346)
	scala.meta.internal.pc.SignatureHelpProvider$MethodCallTraverser.$anonfun$visit$5$adapted(SignatureHelpProvider.scala:323)
	scala.collection.IterableOnceOps.foreach(IterableOnce.scala:576)
	scala.collection.IterableOnceOps.foreach$(IterableOnce.scala:574)
	scala.collection.AbstractIterable.foreach(Iterable.scala:933)
	scala.collection.IterableOps$WithFilter.foreach(Iterable.scala:903)
	scala.meta.internal.pc.SignatureHelpProvider$MethodCallTraverser.$anonfun$visit$3(SignatureHelpProvider.scala:323)
	scala.meta.internal.pc.SignatureHelpProvider$MethodCallTraverser.$anonfun$visit$3$adapted(SignatureHelpProvider.scala:322)
	scala.collection.IterableOnceOps.foreach(IterableOnce.scala:576)
	scala.collection.IterableOnceOps.foreach$(IterableOnce.scala:574)
	scala.collection.AbstractIterable.foreach(Iterable.scala:933)
	scala.collection.IterableOps$WithFilter.foreach(Iterable.scala:903)
	scala.meta.internal.pc.SignatureHelpProvider$MethodCallTraverser.visit(SignatureHelpProvider.scala:322)
	scala.meta.internal.pc.SignatureHelpProvider$MethodCallTraverser.traverse(SignatureHelpProvider.scala:310)
	scala.meta.internal.pc.SignatureHelpProvider$MethodCallTraverser.fromTree(SignatureHelpProvider.scala:279)
	scala.meta.internal.pc.SignatureHelpProvider.signatureHelp(SignatureHelpProvider.scala:27)
	scala.meta.internal.pc.ScalaPresentationCompiler.$anonfun$signatureHelp$1(ScalaPresentationCompiler.scala:310)
```
#### Short summary: 

scala.reflect.internal.FatalError: 
  Something is wrong: cannot find A in applied type com.OOP.GenericList.Cons
   sought  A in Cons
 classSym  Cons in GenericList
  tparams  A in Cons

     while compiling: file://<WORKSPACE>/src/main/scala/com/OOP/Generics.scala
        during phase: globalPhase=<no phase>, enteringPhase=parser
     library version: version 2.13.12
    compiler version: version 2.13.12
  reconstructed args: -classpath <WORKSPACE>/.bloop/root/bloop-bsp-clients-classes/classes-Metals-cBZDV2eWR8aRHtKqc_2Y4A==:<HOME>/Library/Caches/bloop/semanticdb/com.sourcegraph.semanticdb-javac.0.9.9/semanticdb-javac-0.9.9.jar:<HOME>/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar -Xplugin-require:semanticdb -Yrangepos -Ymacro-expand:discard -Ycache-plugin-class-loader:last-modified -Ypresentation-any-thread

  last tree to typer: Ident(A)
       tree position: line 50 of file://<WORKSPACE>/src/main/scala/com/OOP/Generics.scala
            tree tpe: A
              symbol: type A in class MyList
   symbol definition: +A (a AbstractTypeSymbol)
      symbol package: com.OOP
       symbol owners: type A -> class MyList -> object GenericList
           call site: <none> in <none>

== Source file context for tree position ==

    47 object GenericList {
    48 
    49   abstract class MyList[+A] {
    50     def head: A
    51     def tail: MyList[A]
    52     def add[B >: A](element: B): MyList[B]
    53     def isEmpty: Boolean