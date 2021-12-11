package convertors
import asciiArtApp.models.pixel.ascii.ASCIIPixel
import asciiArtApp.models.pixel.rgb.RGBPixel
import convertors.pixel.ToASCIIPixelConvertor
import org.scalatest.FunSuite

class ToASCIIPixelConvertorTest extends FunSuite {
  def convert(pixel: RGBPixel): ASCIIPixel = new ToASCIIPixelConvertor().convert(pixel)

  test("Convert black pixel") {
    val pixel = RGBPixel(0, 0, 0)
    val result = convert(pixel)

    assert(result == ASCIIPixel("$".head))
  }

  test("Convert white pixel") {
    val pixel = RGBPixel(255, 255, 255)
    val result = convert(pixel)

    assert(result == ASCIIPixel(" ".head))
  }

  test("Convert red pixel") {
    val pixel = RGBPixel(255, 0, 0)
    val result = convert(pixel)

    assert(result == ASCIIPixel("Z".head))
  }

  test("Convert random pixel") {
    val pixel = RGBPixel(128, 123, 78)
    val result = convert(pixel)

    assert(result == ASCIIPixel("c".head))
  }

  test("Convert error or other edge case? Non existent?") {

  }
}
