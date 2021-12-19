package asciiArtApp.filters.image.defaults

import asciiArtApp.models.grid.pixel.GreyscaleGrid
import asciiArtApp.models.image.grid.GreyscaleImage
import asciiArtApp.models.pixel.char.GreyscalePixel
import org.scalatest.FunSuite

class ImageIdentityFilterTest extends  FunSuite {
  test("Returns same image") {
    val asciiImage = GreyscaleImage(2, 3, GreyscaleGrid(2, Array(GreyscalePixel("Z".head, 76),
      GreyscalePixel("#".head, 32), GreyscalePixel(";".head, 226), GreyscalePixel("|".head, 154),
      GreyscalePixel(" ".head, 255), GreyscalePixel("$".head, 0))))

    val filtered = new ImageIdentityFilter().filter(asciiImage)

    assert(asciiImage == filtered)
  }

  test("Returns same image v2") {
    val asciiImage = GreyscaleImage(0, 0, GreyscaleGrid(0, Array[GreyscalePixel]()))

    val filtered = new ImageIdentityFilter().filter(asciiImage)

    assert(asciiImage == filtered)
  }
}
