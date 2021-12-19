package asciiArtApp.loaders.file.specific

import asciiArtApp.loaders.image.file.specific.{BitmapLoader, JpgLoader, PngLoader}
import asciiArtApp.models.image.grid.RgbImage
import org.scalatest.FunSuite

import java.io.File

class BitmapLoaderTest extends FunSuite {
  val colors: String = new File("src/test/resources/colors.bmp").getAbsolutePath
  val biOopPath: String = new File("src/test/resources/bi-oop.jpg").getAbsolutePath
  val imageCowboyPath: String = new File("src/test/resources/image-cowboy.png").getAbsolutePath

  def loadBMP(source: String): RgbImage = new BitmapLoader(source).load()

  test("BMP Loader - Load incorrect format") {
    assertThrows[IllegalArgumentException](loadBMP(imageCowboyPath))
    assertThrows[IllegalArgumentException](loadBMP(biOopPath))
  }

  test("BMP Loader - load incorrect path") {
    assertThrows[IllegalArgumentException](loadBMP("random/nonexistent/path.bmp"))
  }

  test("BMP Loader - load correct file") {
    val img = loadBMP(colors)

    img.foreach(pixel => assert(pixel != null))
  }
}
