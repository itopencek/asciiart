package asciiArtApp.loaders.image.random

import asciiArtApp.loaders.image.RgbImageLoader
import asciiArtApp.models.grid.pixel.RgbGrid
import asciiArtApp.models.image.grid.RgbImage
import asciiArtApp.models.pixel.rgb.RGBPixel

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class RandomRgbImageLoader extends RgbImageLoader {
  private def randInt(upTo: Int): Int = new Random().nextInt(upTo - 1) + 1
  private def randPixel(): RGBPixel = RGBPixel(randInt(255), randInt(255), randInt(255))

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
