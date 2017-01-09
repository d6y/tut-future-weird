There's a markdown file in src/pages that looks like this:

    # Future example

    ```tut
    import scala.concurrent.Future
    import scala.concurrent.ExecutionContext.Implicits.global
    val value = Future { 42 }
    ```

When `value` is shown by the REPL, I'd expect to see a type related to `Future` (e.g.,a success or a promise or something).
Sometimes I do see that. Sometimes I see `List()`:

    tut-future-weird (master +)$ rm target/pages/example.md ; sbt tut; cat target/pages/example.md
    [info] Loading global plugins from /Users/richard/.sbt/0.13/plugins
    [info] Loading project definition from /Users/richard/Developer/tut-future-weird/project
    [info] Set current project to root (in build file:/Users/richard/Developer/tut-future-weird/)
    [info] Running tut.TutMain /Users/richard/Developer/tut-future-weird/src/pages /Users/richard/Developer/tut-future-weird/target/pages .*\.(md|markdown|txt|htm|html) -deprecation -encoding UTF-8 -unchecked -feature -Ywarn-dead-code -Xlint -Xfatal-warnings
    [tut] compiling: /Users/richard/Developer/tut-future-weird/src/pages/example.md
    [success] Total time: 4 s, completed 09-Jan-2017 19:28:20
    # Future example

    ```scala
    scala> import scala.concurrent.Future
    import scala.concurrent.Future

    scala> import scala.concurrent.ExecutionContext.Implicits.global
    import scala.concurrent.ExecutionContext.Implicits.global

    scala> val value = Future { 42 }
    value: scala.concurrent.Future[Int] = List()
    ```

Let's try interactive in SBT....

    tut-future-weird (master +)$ sbt
    [info] Loading global plugins from /Users/richard/.sbt/0.13/plugins
    [info] Loading project definition from /Users/richard/Developer/tut-future-weird/project
    [info] Set current project to root (in build file:/Users/richard/Developer/tut-future-weird/)
    > tut
    [info] Running tut.TutMain /Users/richard/Developer/tut-future-weird/src/pages /Users/richard/Developer/tut-future-weird/target/pages .*\.(md|markdown|txt|htm|html) -deprecation -encoding UTF-8 -unchecked -feature -Ywarn-dead-code -Xlint -Xfatal-warnings
    [tut] compiling: /Users/richard/Developer/tut-future-weird/src/pages/example.md
    [success] Total time: 4 s, completed 09-Jan-2017 19:28:36
    >
    [1]+  Stopped                 sbt
    tut-future-weird (master +)$ cat target/pages/example.md
    # Future example

    ```scala
    scala> import scala.concurrent.Future
    import scala.concurrent.Future

    scala> import scala.concurrent.ExecutionContext.Implicits.global
    import scala.concurrent.ExecutionContext.Implicits.global

    scala> val value = Future { 42 }
    value: scala.concurrent.Future[Int] = List()
    ```

Same thing. Let's try again...

    tut-future-weird (master +)$ fg
    sbt
    > tut
    [info] Running tut.TutMain /Users/richard/Developer/tut-future-weird/src/pages /Users/richard/Developer/tut-future-weird/target/pages .*\.(md|markdown|txt|htm|html) -deprecation -encoding UTF-8 -unchecked -feature -Ywarn-dead-code -Xlint -Xfatal-warnings
    [tut] compiling: /Users/richard/Developer/tut-future-weird/src/pages/example.md
    [success] Total time: 1 s, completed 09-Jan-2017 19:28:47
    >
    [1]+  Stopped                 sbt
    tut-future-weird (master +)$ cat target/pages/example.md
    # Future example

    ```scala
    scala> import scala.concurrent.Future
    import scala.concurrent.Future

    scala> import scala.concurrent.ExecutionContext.Implicits.global
    import scala.concurrent.ExecutionContext.Implicits.global

    scala> val value = Future { 42 }
    value: scala.concurrent.Future[Int] = Success(42)
    ```
    tut-future-weird (master +)$ fg
    sbt
    > argggghhh!
    [error] Unexpected end of input
    [error] argggghhh!
    [error]           ^
