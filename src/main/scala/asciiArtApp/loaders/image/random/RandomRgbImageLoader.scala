package asciiArtApp.loaders.image.random

import asciiArtApp.loaders.image.RgbImageLoader
import asciiArtApp.models.grid.pixel.RgbGrid
import asciiArtApp.models.image.grid.RgbImage
import asciiArtApp.models.pixel.rgb.RGBPixel

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/**
 * Loads random {@link RgbImage}.
 */
class RandomRgbImageLoader extends RgbImageLoader {
  /**
   * Generates random {@link Int}. Can never be zero.
   *
   * @param upTo max size of random {@link Int}
   * @return random {@link Int}
   */
  private def randInt(upTo: Int): Int = new Random().nextInt(upTo - 1) + 1

  /**
   * Generates random {@link RGBPixel}.
   *
   * @return random {@link RGBPixel}
   */
  private def randPixel(): RGBPixel = RGBPixel(randInt(255), randInt(255), randInt(255))

  /**
   * Generates random {@link RgbImage}.
   *
   * @return generated {@link RgbImage}
   */
  override def load(): RgbImage = {
    val width = randInt(300)
    val height = randInt(300)
    val data = ArrayBuffer[RGBPixel]()

    for (_ <- 0 until width * height) {
      data.append(randPixel())
    }

    RgbImage(width, height, RgbGrid(width, data.toArray[RGBPixel]))
  }
}
