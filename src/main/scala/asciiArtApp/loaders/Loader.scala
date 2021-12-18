package asciiArtApp.loaders

/**
 * Basic implementation of loader.
 *
 * @tparam T loaded type
 */
trait Loader[T] {
  def load(): T
}
