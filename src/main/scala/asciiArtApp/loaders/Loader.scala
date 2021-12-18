package asciiArtApp.loaders

trait Loader[T] {
  def load(): T
}
