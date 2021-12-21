package asciiArtApp.console.outputs.image.specific

import asciiArtApp.models.grid.pixel.GreyscaleGrid
import asciiArtApp.models.image.grid.GreyscaleImage
import asciiArtApp.models.pixel.char.GreyscalePixel
import exporters.text.concrete.FileOutputExporter
import org.scalatest.FunSuite

import java.io.File

class FileOutputTest extends FunSuite {

  test("Test export empty image") {
    val image =
      GreyscaleImage(0, 0, GreyscaleGrid(0, Array[GreyscalePixel]()))

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
