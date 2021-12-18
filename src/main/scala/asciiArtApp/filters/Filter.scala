package asciiArtApp.filters

trait Filter[T] {
  def filter(item: T): T
}
