package asciiArtApp.loaders.file.specific

import asciiArtApp.loaders.image.file.specific.PngLoader
import asciiArtApp.models.image.grid.RgbImage
import org.scalatest.FunSuite

import java.io.File

class PngLoaderTest extends FunSuite {
  val colors: String = new File("src/test/resources/colors.bmp").getAbsolutePath
  val biOopPath: String = new File("src/test/resources/bi-oop.jpg").getAbsolutePath
  val imageCowboyPath: String = new File("src/test/resources/image-cowboy.png").getAbsolutePath
  val imageCowboyString = "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 7951688 0 0 7951688 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 10395294 10395294 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2201331 0 0 2201331 0 0 0 0 0 0 0 0 0 0 0 0 0 0 7951688 2201331 0 0 0 0 2201331 7951688 0 0 0 0 0 0 0 0 0 0 0 0 7951688 2201331 0 0 0 0 2201331 7951688 0 0 0 0 0 0 0 0 0 0 0 0 0 2201331 0 0 0 0 2201331 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2201331 0 0 0 0 2201331 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2201331 0 0 0 0 2201331 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2201331 0 0 0 0 2201331 0 0 0 0 0 0 0 0 0 0 0 0 0 7951688 7951688 7951688 0 0 7951688 7951688 7951688 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0"

  def loadPNG(source: String): RgbImage = new PngLoader(source).load()

  test("PNG Loader - Load incorrect format") {
    assertThrows[IllegalArgumentException](loadPNG(biOopPath))
    assertThrows[IllegalArgumentException](loadPNG(colors))
  }

  test("PNG Loader - load incorrect path") {
    assertThrows[IllegalArgumentException](loadPNG("random/nonexistent/path.png"))
  }

  test("PNG Loader - load correct file") {
    val img = loadPNG(imageCowboyPath)
    var data = ""

    img.foreach(pixel => data += pixel.getInt() + " ")
    // remove last space
    data = data.dropRight(1)

    assert(data == imageCowboyString)
  }
}
