package asciiArtApp.loaders.file.specific

import asciiArtApp.loaders.image.file.specific.JpgLoader
import asciiArtApp.models.image.grid.RgbImage
import org.scalatest.FunSuite

import java.io.File

class JpgLoaderTest extends FunSuite {
  val colors: String = new File("src/test/resources/colors.bmp").getAbsolutePath
  val biOopPath: String = new File("src/test/resources/bi-oop.jpg").getAbsolutePath
  val imageCowboyPath: String = new File("src/test/resources/image-cowboy.png").getAbsolutePath

  def loadJPG(source: String): RgbImage = new JpgLoader(source).load()

  test("JPG Loader - Load incorrect format") {
    assertThrows[IllegalArgumentException](loadJPG(imageCowboyPath))
    assertThrows[IllegalArgumentException](loadJPG(colors))
  }

  test("JPG Loader - load incorrect path") {
    assertThrows[IllegalArgumentException](loadJPG("random/nonexistent/path.jpg"))
  }

  test("JPG Loader - load correct file") {
    val img = loadJPG(biOopPath)

    img.foreach(pixel => assert(pixel != null))
  }
}
