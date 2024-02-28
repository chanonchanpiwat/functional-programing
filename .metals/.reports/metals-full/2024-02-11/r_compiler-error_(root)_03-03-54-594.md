file://<WORKSPACE>/src/main/scala/com/example/call_by.scala
### java.lang.IndexOutOfBoundsException: 7

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 2.13.12
Classpath:
<WORKSPACE>/.bloop/root/bloop-bsp-clients-classes/classes-Metals-5_CWDiKZQp-z6ykuyXqrxQ== [exists ], <HOME>/Library/Caches/bloop/semanticdb/com.sourcegraph.semanticdb-javac.0.9.9/semanticdb-javac-0.9.9.jar [exists ], <HOME>/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ]
Options:
-Yrangepos -Xplugin-require:semanticdb


action parameters:
offset: 0
uri: file://<WORKSPACE>/src/main/scala/com/example/call_by.scala
text:
```scala
@@
```



#### Error stacktrace:

```
scala.reflect.internal.util.BatchSourceFile.offsetToLine(SourceFile.scala:201)
	scala.meta.internal.pc.MetalsGlobal$XtensionPositionMetals.toPos(MetalsGlobal.scala:677)
	scala.meta.internal.pc.MetalsGlobal$XtensionPositionMetals.toLsp(MetalsGlobal.scala:690)
	scala.meta.internal.pc.PcDocumentHighlightProvider.collect(PcDocumentHighlightProvider.scala:21)
	scala.meta.internal.pc.PcDocumentHighlightProvider.collect(PcDocumentHighlightProvider.scala:9)
	scala.meta.internal.pc.PcCollector.scala$meta$internal$pc$PcCollector$$collect$1(PcCollector.scala:315)
	scala.meta.internal.pc.PcCollector.traverseWithParent$1(PcCollector.scala:384)
	scala.meta.internal.pc.PcCollector.traverseSought(PcCollector.scala:521)
	scala.meta.internal.pc.PcCollector.resultWithSought(PcCollector.scala:289)
	scala.meta.internal.pc.PcCollector.result(PcCollector.scala:218)
	scala.meta.internal.pc.PcDocumentHighlightProvider.highlights(PcDocumentHighlightProvider.scala:30)
	scala.meta.internal.pc.ScalaPresentationCompiler.$anonfun$documentHighlight$1(ScalaPresentationCompiler.scala:368)
```
#### Short summary: 

java.lang.IndexOutOfBoundsException: 7