package asciiArtApp.filters.image.specific

import asciiArtApp.filters.image.ImageFilter
import asciiArtApp.models.grid.pixel.GreyscaleGrid
import asciiArtApp.models.image.grid.GreyscaleImage
import asciiArtApp.models.pixel.char.GreyscalePixel

import scala.collection.mutable.ArrayBuffer

/**
 * Specific {@link ImageFilter}, which inverts greyscale value of {@link GreyscalePixel}.
 */
class InvertFilter extends ImageFilter {

  /**
   * Inverts {@link GreyscaleImage}.
   *
   * @param item {@link GreyscaleImage} to invert
   * @return {@link GreyscaleImage} inverted
   */
  override def filter(item: GreyscaleImage): GreyscaleImage = {
    val data = ArrayBuffer[GreyscalePixel]()
    item.foreach(pixel => {
      data.append(GreyscalePixel(255 - pixel.brightness))
    })

    item.newImage(GreyscaleGrid(item.getWidth(), data.toArray[GreyscalePixel]))
  }
}
