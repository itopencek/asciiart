package asciiArtApp.filters.image.mixed

import asciiArtApp.filters.image.specific.{BrightnessFilter, FlipFilter, InvertFilter}
import asciiArtApp.models.`enum`.FlipEnum
import asciiArtApp.models.grid.pixel.GreyscaleGrid
import asciiArtApp.models.image.grid.GreyscaleImage
import asciiArtApp.models.pixel.char.GreyscalePixel
import org.scalatest.FunSuite

class MixedFilterTest extends FunSuite {
  test("Test all filters") {
    val image =
      GreyscaleImage(2, 3, GreyscaleGrid(2,Array(
        GreyscalePixel(255),
        GreyscalePixel(0),
        GreyscalePixel(255),
        GreyscalePixel(0),
        GreyscalePixel(255),
        GreyscalePixel(0))))

    val expected = GreyscaleImage(2, 3, GreyscaleGrid(2, Array(GreyscalePixel(0), GreyscalePixel(155),
      GreyscalePixel(0), GreyscalePixel(155), GreyscalePixel(0), GreyscalePixel(155))))

    val filtered = new MixedFilter(Array(new BrightnessFilter(100), new FlipFilter(FlipEnum.X),
      new InvertFilter())).filter(image)

    assert(expected == filtered)
  }

  test("Test no filters") {
    val image =
      GreyscaleImage(0, 0, GreyscaleGrid(0, Array[GreyscalePixel]()))

    val filtered = new MixedFilter(Array(new BrightnessFilter(100), new FlipFilter(FlipEnum.X),
      new InvertFilter())).filter(image)

    assert(image == filtered)
  }
}
