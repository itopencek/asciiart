package asciiArtApp.filters.defaults

import asciiArtApp.models.pixel.rgb.RGBPixel
import org.scalatest.FunSuite

class IdentityFilterTest extends FunSuite {
  test("Test returns same string") {
    val text = "Test text"
    val filtered = new IdentityFilter[String]().filter(text)

    assert(text == filtered)
  }

  test("Test returns same object") {
    val pixel = RGBPixel(10, 20, 30)
    val filtered = new IdentityFilter[RGBPixel]().filter(pixel)

    assert(pixel == filtered)
  }
}
