package asciiArtApp.convertors.image.character.pixel

import asciiArtApp.models.pixel.char.{CharPixel, GreyscalePixel}
import org.scalatest.FunSuite

class GreyscalePixelConvertorTest extends FunSuite {
  def convert(table: String, pixel: GreyscalePixel): CharPixel = new GreyscalePixelConvertor(table).convert(pixel)
  private val smallTable = "@* "
  private val bigTable = "qwertyuiopasdfghjklzxcvbnm987654321 "

  test("Very small table size") {
    assertThrows[Exception](convert("@ ", GreyscalePixel(72)))
  }

  test("With small table") {
    val result = convert(smallTable, GreyscalePixel(72))
    assert(result == CharPixel('@'))
  }

  test("With small table 2") {
    val result = convert(smallTable, GreyscalePixel(255))
    assert(result == CharPixel(' '))
  }

  test("With small table 3") {
    val result = convert(smallTable, GreyscalePixel(128))
    assert(result == CharPixel('*'))
  }

  test("With big table") {
    val result = convert(bigTable, GreyscalePixel(128))
    assert(result == CharPixel('k'))
  }

  test("With big table 2") {
    val result = convert(bigTable, GreyscalePixel(255))
    assert(result == CharPixel(' '))
  }
}
