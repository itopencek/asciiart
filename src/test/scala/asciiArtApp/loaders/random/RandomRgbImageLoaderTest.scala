package asciiArtApp.loaders.random

import asciiArtApp.loaders.image.random.RandomRgbImageLoader
import asciiArtApp.models.image.grid.RgbImage
import org.scalatest.FunSuite

class RandomRgbImageLoaderTest extends FunSuite {
  def load(): RgbImage = new RandomRgbImageLoader().load()

  test("Load random image") {
    testImage(load())
    testImage(load())
    testImage(load())
    testImage(load())
    testImage(load())
  }

  def testImage(image: RgbImage): Unit = {
    assert(image.getHeight() < 301 & image.getHeight() > 0)
    assert(image.getWidth() < 301 & image.getHeight() > 0)
    image.foreach(pixel => {
      assert(pixel.r < 256 & pixel.r >= 0)
      assert(pixel.g < 256 & pixel.g >= 0)
      assert(pixel.b < 256 & pixel.b >= 0)
    })
  }
}
