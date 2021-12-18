package asciiArtApp.convertors.image.pixel

import asciiArtApp.models.pixel.char.GreyscalePixel
import asciiArtApp.models.pixel.rgb.RGBPixel
import org.scalatest.FunSuite

class PixelConvertorTest extends FunSuite {
  def convert(table: String, pixel: RGBPixel): GreyscalePixel = new PixelConvertor(table).convert(pixel)
  private val smallTable = "@* "
  private val bigTable = "qwertyuiopasdfghjklzxcvbnm987654321 "

  test("Very small table size") {
    assertThrows[Exception](convert("@ ", RGBPixel(255, 0, 0)))
  }

  test("With small table") {
    val result = convert(smallTable, RGBPixel(255, 0, 0))
    assert(result == GreyscalePixel("@".head))
  }

  test("With small table 2") {
    val result = convert(smallTable, RGBPixel(128, 128, 128))
    assert(result == GreyscalePixel("*".head))
  }

  test("With big table") {
    val result = convert(bigTable, RGBPixel(128, 128, 128))
    assert(result == GreyscalePixel("k".head))
  }

  test("With big table 2") {
    val result = convert(bigTable, RGBPixel(255, 255, 255))
    assert(result == GreyscalePixel(" ".head))
  }
}
