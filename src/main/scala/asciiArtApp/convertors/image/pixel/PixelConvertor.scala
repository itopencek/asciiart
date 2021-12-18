package asciiArtApp.convertors.image.pixel

import asciiArtApp.convertors.Convertor
import asciiArtApp.models.pixel.char.GreyscalePixel
import asciiArtApp.models.pixel.rgb.RGBPixel

/**
 * Convertor, which converts {@link RGBPixel} to {@link GreyscalePixel}.
 *
 * @param asciiCharsTable string of characters to use as conversion table in conversion
 */
class PixelConvertor(asciiCharsTable: String) extends Convertor[RGBPixel, GreyscalePixel] {
  private val tableLength = asciiCharsTable.length

  /**
   * Converts {@link RGBPixel} to {@link GreyscalePixel}.
   *
   * @param item {@link RGBPixel} to convert
   * @return converted {@link GreyscalePixel}
   * @throws Exception when character table is too small
   */
  override def convert(item: RGBPixel): GreyscalePixel = {
    val greyscale = (0.3 * item.r) + (0.59 * item.g) + (0.11 * item.b)

    if (tableLength < 3) {
      throw new Exception("Char table is too small, needs to have at least 3 chars. Has " + tableLength + ".")
    }
    val index = ((tableLength - 1) * greyscale / 255).toInt

    GreyscalePixel(asciiCharsTable.charAt(index), greyscale.toInt)
  }

  /**
   * Returns {@link GreyscalePixel} with specific greyscale value.
   *
   * @param greyscale value to convert pixel to
   * @return converted {@link GreyscalePixel}
   */
  def convert(greyscale: Int): GreyscalePixel = {
    val index: Int = (tableLength - 1) * greyscale / 255

    GreyscalePixel(asciiCharsTable.charAt(index), greyscale)
  }
}
