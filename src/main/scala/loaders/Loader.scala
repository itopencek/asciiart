package loaders

trait Loader[T, U] {
  def load(source: U): T
}
