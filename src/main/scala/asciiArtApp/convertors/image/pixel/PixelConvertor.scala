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
  private val rampLength = asciiCharsTable.length

  /**
   * Converts {@link RGBPixel} to {@link GreyscalePixel}.
   *
   * @param item {@link RGBPixel} to convert
   * @return converted {@link GreyscalePixel}
   */
  override def convert(item: RGBPixel): GreyscalePixel = {
    val greyscale = (0.3 * item.r) + (0.59 * item.g) + (0.11 * item.b)

    if (rampLength < 3) {
      throw new Exception("Char table is too small, needs to have at least 3 chars. Has " + rampLength + ".")
    }
    val index = ((rampLength - 1) * greyscale / 255).toInt

    GreyscalePixel(asciiCharsTable.charAt(index), greyscale.toInt)
  }

  /**
   * Converts {@link GreyscalePixel} to specific greyscale value.
   *
   * @param item {@link GreyscalePixel} to convert
   * @param greyscale value to convert pixel to
   * @return converted {@link GreyscalePixel}
   */
  def convert(item: GreyscalePixel, greyscale: Int): GreyscalePixel = {
    val index: Int = (rampLength - 1) * greyscale / 255

    GreyscalePixel(asciiCharsTable.charAt(index), greyscale)
  }
}
