package asciiArtApp.convertors.image.character.pixel

import asciiArtApp.convertors.Convertor
import asciiArtApp.models.pixel.char.{CharPixel, GreyscalePixel}

/**
 * Convertor, which converts {@link GreyscalePixel} to {@link CharPixel}.
 *
 * @param asciiCharsTable string of characters to use as conversion table in conversion
 */
class GreyscalePixelConvertor(asciiCharsTable: String) extends Convertor[GreyscalePixel, CharPixel] {
  private val tableLength = asciiCharsTable.length

  /**
   * Converts {@link GreyscalePixel} to {@link CharPixel}.
   *
   * @param item {@link GreyscalePixel} to convert
   * @return converted {@link CharPixel}
   * @throws Exception when character table is too small
   */
  override def convert(item: GreyscalePixel): CharPixel = {
    if (tableLength < 3) {
      throw new Exception("Char table is too small, needs to have at least 3 chars. Has " + tableLength + ".")
    }
    if (item.brightness > 255) {
      throw new IndexOutOfBoundsException("Brightness is out of range.")
    }

    val index = (tableLength - 1) * item.brightness / 255

    CharPixel(asciiCharsTable.charAt(index))
  }
}
