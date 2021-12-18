package asciiArtApp.filters

/**
 * Basic interface for filter.
 *
 * @tparam T type of item to filter
 */
trait Filter[T] {
  def filter(item: T): T
}
