package asciiArtApp.convertors.image.rgb.pixel

import asciiArtApp.models.pixel.char.GreyscalePixel
import asciiArtApp.models.pixel.rgb.RGBPixel
import org.scalatest.FunSuite

class RgbPixelConvertorTest extends FunSuite {
  def convert(pixel: RGBPixel): GreyscalePixel = new RgbPixelConvertor().convert(pixel)

  test("Convert black pixel") {
    val pixel = RGBPixel(0, 0, 0)
    val result = convert(pixel)

    assert(result == GreyscalePixel(0))
  }

  test("Convert white pixel") {
    val pixel = RGBPixel(255, 255, 255)
    val result = convert(pixel)

    assert(result == GreyscalePixel(255))
  }

  test("Convert red pixel") {
    val pixel = RGBPixel(255, 0, 0)
    val result = convert(pixel)

    assert(result == GreyscalePixel(76))
  }

  test("Convert random pixel") {
    val pixel = RGBPixel(128, 123, 78)
    val result = convert(pixel)

    assert(result == GreyscalePixel(119))
  }
}
