package asciiArtApp.convertors.image

import asciiArtApp.console.views.rendering.ImageTextRenderVisitor
import asciiArtApp.loaders.image.file.FileRgbImageLoader
import asciiArtApp.models.grid.pixel.CharGrid
import asciiArtApp.models.images.grid.{CharImage, RgbImage}
import asciiArtApp.models.pixel.char.CharPixel
import org.scalatest.FunSuite

import java.io.File
import scala.collection.mutable.ListBuffer

class ToAsciiImageConvertorTest extends FunSuite {
  def imageConvertor(item: RgbImage): CharImage = new ToAsciiImageConvertor().convert(item)
  def load(source: String): RgbImage = new FileRgbImageLoader().load(source)
  val imageColors: RgbImage = load(new File("src/test/resources/colors.bmp").getAbsolutePath)
  val imageOop: RgbImage = load(new File("src/test/resources/bi-oop.jpg").getAbsolutePath)
  val imageCowboy: RgbImage = load(new File("src/test/resources/image-cowboy.png").getAbsolutePath)
  val imageUsa: RgbImage = load(new File("src/test/resources/statue-of-liberty.jpg").getAbsolutePath)

  test("Test basic conversion") {
    val result = imageConvertor(imageColors)
    val asciiImage = CharImage(2, 3, CharGrid(2, ListBuffer(CharPixel("Z".head), CharPixel("#".head),
      CharPixel(";".head), CharPixel("|".head), CharPixel(" ".head), CharPixel("$".head))))

    assert(result == asciiImage)
  }
  // TODO
  test("Cowboy") {
    val result = imageConvertor(imageCowboy)
    val visitor = new ImageTextRenderVisitor
    print(visitor.visitAsciiImage(result))
  }
}
