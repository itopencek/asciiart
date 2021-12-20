package asciiArtApp.filters.image.specific

import asciiArtApp.ImageTextRenderVisitor
import asciiArtApp.convertors.image.ToAsciiImageConvertor
import asciiArtApp.loaders.image.file.specific.JpgLoader
import asciiArtApp.models.`enum`.FlipEnum
import asciiArtApp.models.`enum`.FlipEnum.FlipEnum
import asciiArtApp.models.grid.pixel.GreyscaleGrid
import asciiArtApp.models.image.grid.{GreyscaleImage, RgbImage}
import asciiArtApp.models.pixel.char.GreyscalePixel
import org.scalatest.FunSuite

import java.io.File

class FlipFilterTest extends FunSuite {
  val BASE_URL = "src/test/resources/"
  val pathToFreedom: String = new File("src/test/resources/statue-of-liberty.jpg").getAbsolutePath

  def loadJPG(source: String): RgbImage = new JpgLoader(source).load()
  def convertor(item: RgbImage): GreyscaleImage = new ToAsciiImageConvertor().convert(item)
  def filter(axis: FlipEnum, image: GreyscaleImage): GreyscaleImage = new FlipFilter(axis).filter(image)
  def getString(image: GreyscaleImage): String = new ImageTextRenderVisitor().visitGreyscaleImage(image)

  test("Test flip small image") {
    val image =
      GreyscaleImage(2, 1, GreyscaleGrid(2, Array(GreyscalePixel(" ".head, 255), GreyscalePixel("$".head, 0))))

    val expected =
      GreyscaleImage(2, 1, GreyscaleGrid(2, Array(GreyscalePixel("$".head, 0), GreyscalePixel(" ".head, 255))))

    val filtered = filter(FlipEnum.Y, image)

    assert(expected == filtered)
  }

  test("Test flip X statue") {
    val image = convertor(loadJPG(pathToFreedom))

    val filtered = filter(FlipEnum.X, image)
    val filteredString = getString(filtered)

    val expected = loadFile(BASE_URL + "filtered/flipped/flipped-statue-x.txt")

    assert(expected == filteredString)
  }

  test("Test flip Y statue") {
    val image = convertor(loadJPG(pathToFreedom))

    val filtered = filter(FlipEnum.Y, image)
    val filteredString = getString(filtered)

    val expected = loadFile(BASE_URL + "filtered/flipped/flipped-statue-y.txt")

    assert(expected == filteredString)
  }

  test("Test flip YX statue") {
    val image = convertor(loadJPG(pathToFreedom))

    val filtered = filter(FlipEnum.Y, image)
    val filtered2 = filter(FlipEnum.X, filtered)
    val filteredString = getString(filtered2)

    val expected = loadFile(BASE_URL + "filtered/flipped/flipped-statue-xy.txt")

    assert(expected == filteredString)
  }

  test("Test flip XY statue") {
    val image = convertor(loadJPG(pathToFreedom))

    val filtered = filter(FlipEnum.X, image)
    val filtered2 = filter(FlipEnum.Y, filtered)
    val filteredString = getString(filtered2)

    val expected = loadFile(BASE_URL + "filtered/flipped/flipped-statue-xy.txt")

    assert(expected == filteredString)
  }

  test("Test flip XX statue") {
    val image = convertor(loadJPG(pathToFreedom))

    val filtered = filter(FlipEnum.X, image)
    val filtered2 = filter(FlipEnum.X, filtered)
    val filteredString = getString(filtered2)

    val expected = loadFile(BASE_URL + "converted/statue.txt")

    assert(expected == filteredString)
  }

  test("Test flip YY image") {
    val image =
      GreyscaleImage(2, 1, GreyscaleGrid(2, Array(GreyscalePixel(" ".head, 255), GreyscalePixel("$".head, 0))))

    val filtered = filter(FlipEnum.Y, image)
    val filtered2 = filter(FlipEnum.Y, filtered)

    assert(image == filtered2)
  }

  test("Test flip YYY image") {
    val image =
      GreyscaleImage(2, 1, GreyscaleGrid(2, Array(GreyscalePixel(" ".head, 255), GreyscalePixel("$".head, 0))))

    val expected =
      GreyscaleImage(2, 1, GreyscaleGrid(2, Array(GreyscalePixel("$".head, 0), GreyscalePixel(" ".head, 255))))

    var filtered = filter(FlipEnum.Y, image)
    filtered = filter(FlipEnum.Y, filtered)
    filtered = filter(FlipEnum.Y, filtered)

    assert(expected == filtered)
  }

  test("Test flip empty image") {
    val image =
      GreyscaleImage(0, 0, GreyscaleGrid(0, Array[GreyscalePixel]()))

    val filtered = filter(FlipEnum.X, image)

    assert(filtered == image)
  }

  private def loadFile(path: String): String = {
    val source = scala.io.Source.fromFile(path)
    try source.mkString finally source.close()
  }
}
