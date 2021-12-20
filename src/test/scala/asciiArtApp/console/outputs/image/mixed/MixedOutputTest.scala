package asciiArtApp.console.outputs.image.mixed

import asciiArtApp.console.outputs.image.ImageOutput
import asciiArtApp.console.outputs.image.specific.FileOutput
import asciiArtApp.models.grid.pixel.GreyscaleGrid
import asciiArtApp.models.image.grid.GreyscaleImage
import asciiArtApp.models.pixel.char.GreyscalePixel
import org.scalatest.FunSuite

import java.io.File

class MixedOutputTest extends FunSuite {
  test("Test export empty image") {
    val image =
      GreyscaleImage(2, 3, GreyscaleGrid(2,Array(
        GreyscalePixel('$', 0),
        GreyscalePixel(' ', 255),
        GreyscalePixel('$', 0),
        GreyscalePixel(' ', 255),
        GreyscalePixel('$', 0),
        GreyscalePixel(' ', 255)
      )))

    val exporter = new FileOutput(new File("src/test/resources/exports/test3.out"))
    val exporter2 = new FileOutput(new File("src/test/resources/exports/test4.out"))

    new MixedOutput(Array(exporter, exporter2)).output(image)

    val loaded = loadFile("src/test/resources/exports/test3.out")
    val loaded2 = loadFile("src/test/resources/exports/test4.out")
    val expected = "$ \n$ \n$ \n"

    assert(expected == loaded)
    assert(expected == loaded2)
  }

  test("Test with no outputs") {
    val image =
      GreyscaleImage(2, 3, GreyscaleGrid(2,Array(
        GreyscalePixel('$', 0),
        GreyscalePixel(' ', 255),
        GreyscalePixel('$', 0),
        GreyscalePixel(' ', 255),
        GreyscalePixel('$', 0),
        GreyscalePixel(' ', 255)
      )))

    new MixedOutput(Array[ImageOutput]()).output(image)

    assert(true)
  }

  private def loadFile(path: String): String = {
    val source = scala.io.Source.fromFile(path)
    try source.mkString finally source.close()
  }
}
