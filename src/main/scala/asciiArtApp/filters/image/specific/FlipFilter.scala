package asciiArtApp.filters.image.specific

import asciiArtApp.filters.image.ImageFilter
import asciiArtApp.models.`enum`.FlipEnum
import asciiArtApp.models.`enum`.FlipEnum.FlipEnum
import asciiArtApp.models.grid.pixel.GreyscaleGrid
import asciiArtApp.models.image.grid.GreyscaleImage
import asciiArtApp.models.pixel.char.GreyscalePixel

import scala.collection.mutable.ArrayBuffer

/**
 * Specific {@link ImageFilter}, which flips {@link GreyscaleImage} on X or Y axis.
 *
 * @param flip axis to flip the {@link GreyscaleImage} on
 */
class FlipFilter(flip: FlipEnum) extends ImageFilter {
  /**
   * Flips {@link GreyscaleImage} on axis X  or Y.
   *
   * @param item {@link GreyscaleImage} to filter
   * @return filtered {@link GreyscaleImage}
   */
  override def filter(item: GreyscaleImage): GreyscaleImage = {
    val width = item.getWidth()
    var data = ArrayBuffer[GreyscalePixel]()

    if (flip == FlipEnum.X) {
      data = flipAxisX(item, data)
    } else {
      data = flipAxisY(item, data)
    }

    item.newImage(GreyscaleGrid(width, data.toArray[GreyscalePixel]))
  }

  /**
   * Flips {@link GreyscaleImage} on X axis.
   *
   * @param item {@link GreyscaleImage} to flip
   * @param data {@link ArrayBuffer} for flipped {@link GreyscalePixel}
   * @return flipped {@link ArrayBuffer}
   */
  private def flipAxisX(item: GreyscaleImage, data: ArrayBuffer[GreyscalePixel]): ArrayBuffer[GreyscalePixel] = {
    for(y <- (item.getHeight() - 1) to 0 by -1) {
      for(x <- 0 until item.getWidth()){
        data.append(item.getPixel(x, y))
      }
    }

    data
  }

  /**
   * Flips {@link GreyscaleImage} on Y axis.
   *
   * @param item {@link GreyscaleImage} to flip
   * @param data {@link ArrayBuffer} for flipped {@link GreyscalePixel}
   * @return flipped {@link ArrayBuffer}
   */
  private def flipAxisY(item: GreyscaleImage, data: ArrayBuffer[GreyscalePixel]): ArrayBuffer[GreyscalePixel] = {
    for(y <- 0 until item.getHeight()) {
      for(x <- (item.getWidth() - 1) to 0 by -1){
        data.append(item.getPixel(x, y))
      }
    }

    data
  }
}
