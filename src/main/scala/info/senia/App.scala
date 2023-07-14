package info.senia

import zio.*
import zio.cli.*

object App extends ZIOCliDefault {

  private val opts = Options.text("abc")
  private val args = Args.text("args").*

  override def cliApp: CliApp[Any with ZIOAppArgs with Scope, Any, Any] =
    CliApp.make(
      "test",
      "0.1.0",
      HelpDoc.Span.text("Reproduce -- issue"),
      command = Command("test", opts.optional, args)
    ) { (opts, args) =>
      ZIO.debug(s"opts: $opts") *>
      ZIO.debug(s"args: $args")
    }
}


