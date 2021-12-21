package asciiArtApp.convertors.image.character

import asciiArtApp.convertors.image.character.pixel.ToAsciiPixelConvertor
import asciiArtApp.models.grid.pixel.CharGrid
import asciiArtApp.models.image.grid.{CharImage, GreyscaleImage}
import asciiArtApp.models.pixel.char.{CharPixel, GreyscalePixel}

import scala.collection.mutable.ArrayBuffer

/**
 * Implementation of {@link CharImageConvertor}.
 */
class ToAsciiImageConvertor extends CharImageConvertor {
  /**
   * PixelConvertor to convert individual {@link GreyscalePixel}s to {@link CharPixel} in ASCII.
   */
  private def pixelConvertor = new ToAsciiPixelConvertor

  /**
   * Converts {@link GreyscalePixel} to {@link CharPixel}.
   *
   * @param pixel {@link GreyscalePixel} to convert
   * @return converted {@link CharPixel}
   */
  private def convert(pixel: GreyscalePixel): CharPixel = pixelConvertor.convert(pixel)

  /**
   * Converts {@link GreyscaleImage} to {@link CharImage}.
   *
   * @param item {@link GreyscaleImage} to convert
   * @return converted {@link CharImage}
   */
  override def convert(item: GreyscaleImage): CharImage = {
    val width = item.getWidth()
    val data = new ArrayBuffer[CharPixel]()
    item.foreach(pixel => data.append(convert(pixel)))

    CharImage(width, item.getHeight(), CharGrid(width, data.toArray[CharPixel]))
  }
}
