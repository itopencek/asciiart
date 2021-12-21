package asciiArtApp.convertors.image.character

import asciiArtApp.models.grid.pixel.{CharGrid, GreyscaleGrid}
import asciiArtApp.models.image.grid.{CharImage, GreyscaleImage}
import asciiArtApp.models.pixel.char.{CharPixel, GreyscalePixel}
import org.scalatest.FunSuite

class ToAsciiImageConvertorTest extends FunSuite {
  def convert(image: GreyscaleImage): CharImage = new ToAsciiImageConvertor().convert(image)

  test("Test convert image") {
    val image =
      GreyscaleImage(2, 3, GreyscaleGrid(2, Array(
        GreyscalePixel(255),
        GreyscalePixel(0),
        GreyscalePixel(255),
        GreyscalePixel(0),
        GreyscalePixel(255),
        GreyscalePixel(0)
      )))

    val expected =
      CharImage(2, 3, CharGrid(2, Array(
        CharPixel(' '),
        CharPixel('$'),
        CharPixel(' '),
        CharPixel('$'),
        CharPixel(' '),
        CharPixel('$')
      )))

    val result = convert(image)

    assert(expected == result)
  }

  test("Test imageColors conversion") {
    val image = GreyscaleImage(2, 3, GreyscaleGrid(2, Array(GreyscalePixel(76),
      GreyscalePixel(32), GreyscalePixel(226), GreyscalePixel(154),
      GreyscalePixel(255), GreyscalePixel( 0))))

    val expected =
      CharImage(2, 3, CharGrid(2, Array(
        CharPixel('Z'),
        CharPixel('#'),
        CharPixel(';'),
        CharPixel('|'),
        CharPixel(' '),
        CharPixel('$')
      )))

    val result = convert(image)

    assert(expected == result)
  }

  test("Test convert empty image") {
    val image =
      GreyscaleImage(0, 0, GreyscaleGrid(0, Array[GreyscalePixel]()))

    val expected =
      CharImage(0, 0, CharGrid(0, Array[CharPixel]()))

    val result = convert(image)

    assert(expected == result)
  }


}
