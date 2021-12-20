package asciiArtApp

import asciiArtApp.models.grid.pixel.GreyscaleGrid
import asciiArtApp.models.image.grid.GreyscaleImage
import asciiArtApp.models.pixel.char.GreyscalePixel
import org.scalatest.FunSuite

class ImageTextRenderVisitorTest extends FunSuite {

  test("Test render small image") {
    val image =
      GreyscaleImage(2, 1, GreyscaleGrid(2, Array(GreyscalePixel(" ".head, 255), GreyscalePixel("$".head, 0))))

    val expected = " $\n"

    val rendered = new ImageTextRenderVisitor().visitGreyscaleImage(image)

    assert(expected == rendered)
  }

  test("Test render image with more columns") {
    val image =
      GreyscaleImage(2, 3, GreyscaleGrid(2,Array(GreyscalePixel(" ".head, 255),
        GreyscalePixel("$".head, 0),
        GreyscalePixel(" ".head, 255),
        GreyscalePixel("$".head, 0),
        GreyscalePixel(" ".head, 255),
        GreyscalePixel("$".head, 0))))

    val expected = " $\n $\n $\n"

    val rendered = new ImageTextRenderVisitor().visitGreyscaleImage(image)

    assert(expected == rendered)
  }

  test("Test render empty image") {
    val image = GreyscaleImage(0, 0, GreyscaleGrid(0, Array[GreyscalePixel]()))

    val expected = ""

    val rendered = new ImageTextRenderVisitor().visitGreyscaleImage(image)

    assert(expected == rendered)
  }
}
