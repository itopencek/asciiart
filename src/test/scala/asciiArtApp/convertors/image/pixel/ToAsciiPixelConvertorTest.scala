package asciiArtApp.convertors.image.pixel

import asciiArtApp.models.pixel.char.GreyscalePixel
import asciiArtApp.models.pixel.rgb.RGBPixel
import org.scalatest.FunSuite

class ToAsciiPixelConvertorTest extends FunSuite {
  def convert(pixel: RGBPixel): GreyscalePixel = new ToAsciiPixelConvertor().convert(pixel)

  test("Convert black pixel") {
    val pixel = RGBPixel(0, 0, 0)
    val result = convert(pixel)

    assert(result == GreyscalePixel("$".head, 0))
  }

  test("Convert white pixel") {
    val pixel = RGBPixel(255, 255, 255)
    val result = convert(pixel)

    assert(result == GreyscalePixel(" ".head, 255))
  }

  test("Convert red pixel") {
    val pixel = RGBPixel(255, 0, 0)
    val result = convert(pixel)

    assert(result == GreyscalePixel("Z".head, 76))
  }

  test("Convert random pixel") {
    val pixel = RGBPixel(128, 123, 78)
    val result = convert(pixel)

    assert(result == GreyscalePixel("c".head, 119))
  }

  test("Convert error or other edge case? Non existent?") {

  }
}
