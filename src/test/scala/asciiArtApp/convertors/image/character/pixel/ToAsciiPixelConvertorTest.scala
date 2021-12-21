package asciiArtApp.convertors.image.character.pixel

import asciiArtApp.models.pixel.char.{CharPixel, GreyscalePixel}
import org.scalatest.FunSuite

class ToAsciiPixelConvertorTest extends FunSuite {
  def convert(pixel: GreyscalePixel): CharPixel = new ToAsciiPixelConvertor().convert(pixel)

  test("Test out of bounds exception") {
    val pixel = GreyscalePixel(256)

    assertThrows[IndexOutOfBoundsException](convert(pixel))
  }

  test("Test high brightness") {
    val pixel = GreyscalePixel(255)

    val result = convert(pixel)
    val expected = CharPixel(' ')

    assert(result == expected)
  }

  test("Test low brightness") {
    val pixel = GreyscalePixel(0)

    val result = convert(pixel)
    val expected = CharPixel('$')

    assert(result == expected)
  }

  test("Test middle brightness") {
    val pixel = GreyscalePixel(128)

    val result = convert(pixel)
    val expected = CharPixel('n')

    assert(result == expected)
  }

}
