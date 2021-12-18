package asciiArtApp.console.outputs

trait Output[T] {
  def output(item: T): Unit
}
