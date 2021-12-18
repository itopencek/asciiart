package asciiArtApp.convertors.image
import asciiArtApp.convertors.image.pixel.ToAsciiPixelConvertor
import asciiArtApp.models.grid.pixel.GreyscaleGrid
import asciiArtApp.models.image.grid.{GreyscaleImage, RgbImage}
import asciiArtApp.models.pixel.char.GreyscalePixel
import asciiArtApp.models.pixel.rgb.RGBPixel

import scala.collection.mutable.ArrayBuffer

/**
 * Implementation of {@link ImageConvertor}.
 */
class ToAsciiImageConvertor extends ImageConvertor {
  /**
   * PixelConvertor to convert individual {@link RGBPixel}s.
   */
  private def pixelConvertor = new ToAsciiPixelConvertor

  /**
   * Converts {@link RGBPixel} to {@link GreyscalePixel}.
   *
   * @param pixel {@link RGBPixel} to convert
   * @return converted {@link GreyscalePixel}
   */
  private def convert(pixel: RGBPixel): GreyscalePixel = pixelConvertor.convert(pixel)

  /**
   * Converts {@link RgbImage} to {@link GreyscaleImage}.
   *
   * @param item {@link RgbImage} to convert
   * @return converted {@link GreyscaleImage}
   */
  override def convert(item: RgbImage): GreyscaleImage = {
    val width = item.getWidth()
    val data = new ArrayBuffer[GreyscalePixel]()
    item.foreach(pixel => data.append(convert(pixel)))

    GreyscaleImage(width, item.getHeight(), GreyscaleGrid(width, data.toArray[GreyscalePixel]))
  }
}
