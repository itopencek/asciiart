package asciiArtApp.console.outputs.image.specific

import asciiArtApp.models.grid.pixel.CharGrid
import asciiArtApp.models.image.grid.CharImage
import asciiArtApp.models.pixel.char.CharPixel
import exporters.text.concrete.FileOutputExporter
import org.scalatest.FunSuite

import java.io.File

class ImageTextOutputTest extends FunSuite {
  test("Test export 2 images") {
    val image =
      CharImage(2, 3, CharGrid(2,Array(
        CharPixel('$'),
        CharPixel(' '),
        CharPixel('$'),
        CharPixel(' '),
        CharPixel('$'),
        CharPixel(' ')
      )))

    val image2 =
      CharImage(2, 3, CharGrid(2,Array(
        CharPixel('a'),
        CharPixel(' '),
        CharPixel('a'),
        CharPixel(' '),
        CharPixel('a'),
        CharPixel(' ')
      )))

    val exporter =
      new ImageTextOutput(new FileOutputExporter(new File("src/test/resources/exports/test.out")))

    exporter.output(image)
    exporter.output(image2)

    val expected = "$ \n$ \n$ \na \na \na \n"
    val loaded = loadFile("src/test/resources/exports/test.out")

    assert(expected == loaded)
  }

  test("Test export image") {
    val image =
      CharImage(2, 3, CharGrid(2,Array(
        CharPixel(' '),
        CharPixel('$'),
        CharPixel(' '),
        CharPixel('$'),
        CharPixel(' '),
        CharPixel('$')
      )))

    val exporter =
      new ImageTextOutput(new FileOutputExporter(new File("src/test/resources/exports/test.out")))

    exporter.output(image)

    val loaded = loadFile("src/test/resources/exports/test.out")
    val expected = " $\n $\n $\n"

    assert(expected == loaded)
  }

  test("Test export empty image") {
    val image =
      CharImage(0, 0, CharGrid(0, Array[CharPixel]()))

    val exporter =
      new ImageTextOutput(new FileOutputExporter(new File("src/test/resources/exports/test2.out")))

    exporter.output(image)

    val loaded = loadFile("src/test/resources/exports/test2.out")
    val expected = ""

    assert(expected == loaded)
  }

  private def loadFile(path: String): String = {
    val source = scala.io.Source.fromFile(path)
    try source.mkString finally source.close()
  }
}
