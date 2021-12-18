package asciiArtApp.console.outputs

/**
 * Adapter for {@link exporters.Exporter}.
 */
trait Output[T] {
  def output(item: T): Unit
}
