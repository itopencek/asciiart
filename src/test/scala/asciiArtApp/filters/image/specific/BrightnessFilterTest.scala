package asciiArtApp.filters.image.specific

import asciiArtApp.convertors.image.character.ToAsciiImageConvertor
import asciiArtApp.convertors.image.rgb.ToGreyscaleImageConvertor
import asciiArtApp.loaders.image.file.specific.JpgLoader
import asciiArtApp.models.grid.pixel.GreyscaleGrid
import asciiArtApp.models.image.grid.{CharImage, GreyscaleImage, RgbImage}
import asciiArtApp.models.pixel.char.GreyscalePixel
import org.scalatest.FunSuite

import java.io.File

class BrightnessFilterTest extends FunSuite {
  val BASE_URL = "src/test/resources/"
  val pathToFreedom: String = new File("src/test/resources/statue-of-liberty.jpg").getAbsolutePath

  def loadJPG(source: String): RgbImage = new JpgLoader(source).load()
  def convertor(item: RgbImage): GreyscaleImage = new ToGreyscaleImageConvertor().convert(item)
  def filter(brightness: Int, image: GreyscaleImage): GreyscaleImage = new BrightnessFilter(brightness).filter(image)
  def getString(image: GreyscaleImage): String = toString(new ToAsciiImageConvertor().convert(image))

  test("Change brightness to statue by 100") {
    val image = convertor(loadJPG(pathToFreedom))

    val filtered = filter(100, image)
    val filteredString = getString(filtered)

    val expected = loadFile(BASE_URL + "filtered/brightness/brightness-statue-100.txt")

    assert(expected == filteredString)
  }

  test("Change brightness to statue by 255") {
    val image = convertor(loadJPG(pathToFreedom))

    val filtered = filter(255, image)
    val filteredString = getString(filtered)

    val expected = loadFile(BASE_URL + "filtered/brightness/brightness-statue-255.txt")

    assert(expected == filteredString)
  }

  test("Change brightness to statue by -100") {
    val image = convertor(loadJPG(pathToFreedom))

    val filtered = filter(-100, image)
    val filteredString = getString(filtered)

    val expected = loadFile(BASE_URL + "filtered/brightness/brightness-statue-minus-100.txt")

    assert(expected == filteredString)
  }

  test("Change brightness") {
    val image = GreyscaleImage(1, 1, GreyscaleGrid(1, Array(GreyscalePixel(255))))
    val expected = GreyscaleImage(1, 1, GreyscaleGrid(1, Array(GreyscalePixel(0))))

    val filtered = filter(-256, image)

    assert(filtered == expected)
  }

  test("Change brightness of empty image") {
    val image = GreyscaleImage(0, 0, GreyscaleGrid(0, Array[GreyscalePixel]()))

    val filtered = filter(100, image)

    assert(filtered == image)
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
