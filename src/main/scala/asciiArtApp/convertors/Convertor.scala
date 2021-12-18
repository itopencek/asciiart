package asciiArtApp.convertors

/**
 * Basic converter interface.
 *
 * @tparam T type of item to convert
 * @tparam U type of converted item
 */
trait Convertor[T, U] {
  def convert(item: T): U
}
