package asciiArtApp.convertors.image.pixel

import asciiArtApp.models.pixel.char.CharPixel
import asciiArtApp.models.pixel.rgb.RGBPixel
import org.scalatest.FunSuite

class ToAsciiPixelConvertorTest extends FunSuite {
  def convert(pixel: RGBPixel): CharPixel = new ToAsciiPixelConvertor().convert(pixel)

  test("Convert black pixel") {
    val pixel = RGBPixel(0, 0, 0)
    val result = convert(pixel)

    assert(result == CharPixel("$".head))
  }

  test("Convert white pixel") {
    val pixel = RGBPixel(255, 255, 255)
    val result = convert(pixel)

    assert(result == CharPixel(" ".head))
  }

  test("Convert red pixel") {
    val pixel = RGBPixel(255, 0, 0)
    val result = convert(pixel)

    assert(result == CharPixel("Z".head))
  }

  test("Convert random pixel") {
    val pixel = RGBPixel(128, 123, 78)
    val result = convert(pixel)

    assert(result == CharPixel("c".head))
  }

  test("Convert error or other edge case? Non existent?") {

  }
}
