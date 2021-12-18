package asciiArtApp.convertors.image.pixel

import asciiArtApp.convertors.Convertor
import asciiArtApp.models.pixel.char.GreyscalePixel
import asciiArtApp.models.pixel.rgb.RGBPixel

class PixelConvertor(asciiCharsTable: String) extends Convertor[RGBPixel, GreyscalePixel] {
  override def convert(item: RGBPixel): GreyscalePixel = {
    val greyScale = (0.3 * item.r) + (0.59 * item.g) + (0.11 * item.b)
    val rampLength = asciiCharsTable.length

    if (rampLength < 3) {
      throw new Exception("Char table is too small, needs to have at least 3 chars. Has " + rampLength + ".")
    }
    val index = ((rampLength - 1) * greyScale / 255).toInt

    GreyscalePixel(asciiCharsTable.charAt(index))
  }
}
