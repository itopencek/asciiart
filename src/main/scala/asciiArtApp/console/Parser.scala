package asciiArtApp.console

/**
 * Basic parser interface.
 */
trait Parser[T] {
  def parse(arguments: Seq[T]): Unit
}
