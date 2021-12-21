package asciiArtApp.convertors.image.rgb.pixel

import asciiArtApp.convertors.Convertor
import asciiArtApp.models.pixel.char.GreyscalePixel
import asciiArtApp.models.pixel.rgb.RGBPixel

/**
 * Converts {@link RGBPixel} to {@link GreyscalePixel}.
 */
class RgbPixelConvertor extends Convertor[RGBPixel, GreyscalePixel] {
  /**
   * Converts {@link RGBPixel} to {@link GreyscalePixel}.
   *
   * @param item {@link RGBPixel} to convert
   * @return converted {@link GreyscalePixel}
   */
  override def convert(item: RGBPixel): GreyscalePixel = {
    val greyscale = (0.3 * item.r) + (0.59 * item.g) + (0.11 * item.b)

    GreyscalePixel(greyscale.toInt)
  }
}
