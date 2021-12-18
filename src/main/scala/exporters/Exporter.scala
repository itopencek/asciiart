package exporters

/**
 * Basic exporter interface.
 *
 * @tparam T type of item to export
 */
trait Exporter[T] {
  def export(item: T) : Unit
}
