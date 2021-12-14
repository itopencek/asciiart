package asciiArtApp.convertors.image

import asciiArtApp.loaders.image.file.FileRgbImageLoader
import asciiArtApp.models.grid.pixel.CharGrid
import asciiArtApp.models.images.grid.{CharImage, RgbImage}
import asciiArtApp.models.pixel.char.CharPixel
import org.scalatest.FunSuite

import java.io.File

class ToAsciiImageConvertorTest extends FunSuite {
  def imageConvertor(item: RgbImage): CharImage = new ToAsciiImageConvertor().convert(item)
  def load(source: String): RgbImage = new FileRgbImageLoader().load(source)

  val baseUrl = "src/test/resources"
  val imageColors: RgbImage = load(new File(baseUrl + "/colors.bmp").getAbsolutePath)
  val imageOop: RgbImage = load(new File(baseUrl + "/bi-oop.jpg").getAbsolutePath)
  val imageCowboy: RgbImage = load(new File(baseUrl + "/image-cowboy.png").getAbsolutePath)
  val imageUsa: RgbImage = load(new File(baseUrl + "/statue-of-liberty.jpg").getAbsolutePath)

  test("Test basic conversion") {
    val result = imageConvertor(imageColors)
    val asciiImage = CharImage(2, 3, CharGrid(2, Array(CharPixel("Z".head), CharPixel("#".head),
      CharPixel(";".head), CharPixel("|".head), CharPixel(" ".head), CharPixel("$".head))))

    assert(result == asciiImage)
  }

  // TODO
  test("Cowboy") {
    /*val result = imageConvertor(imageUsa)
    val visitor = new ImageTextRenderVisitor

    val resultString = visitor.visitAsciiImage(result)
    val fileContents = Source.fromFile(baseUrl + "/converted/statue-of-liberty.txt").getLines.mkString

    assert(resultString == fileContents)*/

  }
}
