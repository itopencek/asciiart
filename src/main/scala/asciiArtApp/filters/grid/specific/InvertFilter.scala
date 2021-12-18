package asciiArtApp.filters.grid.specific

import asciiArtApp.convertors.image.pixel.ToAsciiPixelConvertor
import asciiArtApp.filters.grid.ImageFilter
import asciiArtApp.models.grid.pixel.GreyscaleGrid
import asciiArtApp.models.image.grid.GreyscaleImage
import asciiArtApp.models.pixel.char.GreyscalePixel

import scala.collection.mutable.ArrayBuffer

/**
 * Specific {@link ImageFilter}, which inverts greyscale value of {@link GreyscalePixel}.
 */
class InvertFilter extends ImageFilter {
  /**
   * Gets specific {@link GreyscalePixel} for given greyscale value.
   *
   * @param value {@link Int} greyscale value
   * @return {@link GreyscalePixel}
   */
  private def convert(value: Int): GreyscalePixel = new ToAsciiPixelConvertor().convert(value)

  /**
   * Inverts {@link GreyscaleImage}.
   *
   * @param item {@link GreyscaleImage} to invert
   * @return {@link GreyscaleImage} inverted
   */
  override def filter(item: GreyscaleImage): GreyscaleImage = {
    val data = ArrayBuffer[GreyscalePixel]()
    item.foreach(pixel => {
      data.append(convert(255 - pixel.getBrightness()))
    })

    item.newImage(GreyscaleGrid(item.getWidth(), data.toArray[GreyscalePixel]))
  }
}
