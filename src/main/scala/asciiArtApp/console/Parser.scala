package asciiArtApp.console

trait Parser[T] {
  def parse(arguments: Seq[T]): Unit
}
