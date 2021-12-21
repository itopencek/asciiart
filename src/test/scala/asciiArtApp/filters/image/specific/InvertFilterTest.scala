package asciiArtApp.filters.image.specific

import asciiArtApp.convertors.image.character.ToAsciiImageConvertor
import asciiArtApp.convertors.image.rgb.ToGreyscaleImageConvertor
import asciiArtApp.loaders.image.file.specific.{JpgLoader, PngLoader}
import asciiArtApp.models.grid.pixel.GreyscaleGrid
import asciiArtApp.models.image.grid.{CharImage, GreyscaleImage, RgbImage}
import asciiArtApp.models.pixel.char.GreyscalePixel
import org.scalatest.FunSuite

import java.io.File

class InvertFilterTest extends FunSuite {
  val BASE_URL = "src/test/resources/"
  val imageCowboyPath: String = new File(BASE_URL + "image-cowboy.png").getAbsolutePath
  val pathToFreedom: String = new File("src/test/resources/statue-of-liberty.jpg").getAbsolutePath

  def loadPNG(source: String): RgbImage = new PngLoader(source).load()
  def loadJPG(source: String): RgbImage = new JpgLoader(source).load()
  def convertor(item: RgbImage): GreyscaleImage = new ToGreyscaleImageConvertor().convert(item)
  def invert(image: GreyscaleImage): GreyscaleImage = new InvertFilter().filter(image)
  def getString(image: GreyscaleImage): String = toString(new ToAsciiImageConvertor().convert(image))

  test("Invert small image") {
    // black - white
    val image =
      GreyscaleImage(1, 2, GreyscaleGrid(1, Array(GreyscalePixel(0), GreyscalePixel(255))))
    // white - black
    val expected =
      GreyscaleImage(1, 2, GreyscaleGrid(1, Array(GreyscalePixel(255), GreyscalePixel(0))))

    val inverted = invert(image)

    assert(expected == inverted)
  }

  test("Invert image") {
    val image = convertor(loadPNG(imageCowboyPath))

    val inverted = invert(image)
    // we get inverted image in string
    val invertedString = getString(inverted)

    // we load correctly inverted image to compare it
    val expected = loadFile(BASE_URL + "filtered/inverted/inverted-cowboy.txt")

    assert(expected == invertedString)
  }

  test("Invert empty image") {
    val image =
      GreyscaleImage(0, 0, GreyscaleGrid(0, Array[GreyscalePixel]()))

    val inverted = invert(image)

    assert(image == inverted)
  }

  test("Invert big image") {
    val image = convertor(loadJPG(pathToFreedom))

    val inverted = invert(image)
    // we get inverted image in string
    val invertedString = getString(inverted)

    // we load correctly inverted image to compare it
    val expected = loadFile(BASE_URL + "filtered/inverted/inverted-statue.txt")

    assert(expected == invertedString)
  }

  test("Invert invert image") {
    // black - white
    val image =
      GreyscaleImage(1, 2, GreyscaleGrid(1, Array(GreyscalePixel(0), GreyscalePixel(255))))

    var inverted = invert(image)
    inverted = invert(inverted)

    assert(image == inverted)
  }

  private def loadFile(path: String): String = {
    val source = scala.io.Source.fromFile(path)
    try source.mkString finally source.close()
  }


  private def toString(item: CharImage): String = {
    var response = ""
    var num = 0

    item.foreach(pixel =>
    {
      response += pixel.character
      num += 1

      if (num % item.getWidth() == 0) {
        response += "\n"
      }
    })

    response
  }
}
