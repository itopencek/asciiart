package asciiArtApp.console.outputs.image.mixed

import asciiArtApp.console.outputs.image.ImageOutput
import asciiArtApp.console.outputs.image.specific.ImageTextOutput
import asciiArtApp.models.grid.pixel.{CharGrid, CharGridTest}
import asciiArtApp.models.image.grid.CharImage
import asciiArtApp.models.pixel.char.CharPixel
import exporters.text.concrete.FileOutputExporter
import org.scalatest.FunSuite

import java.io.File

class MixedOutputTest extends FunSuite {
  test("Test export image to multiple exports") {
    val image =
      CharImage(2, 3, CharGrid(2,Array(
        CharPixel('$'),
        CharPixel(' '),
        CharPixel('$'),
        CharPixel(' '),
        CharPixel('$'),
        CharPixel(' ')
      )))

    val exporter =
      new ImageTextOutput(new FileOutputExporter(new File("src/test/resources/exports/test3.out")))
    val exporter2 =
      new ImageTextOutput(new FileOutputExporter(new File("src/test/resources/exports/test4.out")))

    new MixedOutput(Array(exporter, exporter2)).output(image)

    val loaded = loadFile("src/test/resources/exports/test3.out")
    val loaded2 = loadFile("src/test/resources/exports/test4.out")
    val expected = "$ \n$ \n$ \n"

    assert(expected == loaded)
    assert(expected == loaded2)
  }

  test("Test with no outputs") {
    val image =
      CharImage(2, 3, CharGrid(2,Array(
        CharPixel('$'),
        CharPixel(' '),
        CharPixel('$'),
        CharPixel(' '),
        CharPixel('$'),
        CharPixel(' ')
      )))

    new MixedOutput(Array[ImageOutput]()).output(image)

    assert(true)
  }

  private def loadFile(path: String): String = {
    val source = scala.io.Source.fromFile(path)
    try source.mkString finally source.close()
  }
}
