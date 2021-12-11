package asciiArtApp.convertors

trait Convertor[T, U] {
  def convert(item: T): U
}
