package exporters.text.concrete

import org.scalatest.FunSuite

import java.io.File
import scala.io.Source

class FileOutputExporterTest extends FunSuite {
  private val FILE_PATH = "src/test/resources/exports/test.out"

  test("Test export text") {
    val exporter = new FileOutputExporter(new File(FILE_PATH))
    exporter.`export`("Test string \n asd")
    exporter.`export`("text2")
    exporter.close()

    assert(Source.fromFile(FILE_PATH).mkString == "Test string \n asdtext2")

  }
}
