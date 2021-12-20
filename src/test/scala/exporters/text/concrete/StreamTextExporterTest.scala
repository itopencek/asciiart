package exporters.text.concrete

import org.scalatest.FunSuite

import java.io.{File, FileOutputStream}

class StreamTextExporterTest extends FunSuite {
  private val FILE_PATH = "src/test/resources/exports/test.out"

  test("Test closing closed stream") {
    val exporter = new StreamTextExporter(new FileOutputStream(new File(FILE_PATH)))
    exporter.`export`("Test string")
    exporter.close()
    assertResult(exporter.close())()
  }

  test("Test write to closed stream") {
    val exporter = new StreamTextExporter(new FileOutputStream(new File(FILE_PATH)))
    exporter.`export`("Test string")
    exporter.close()
    assertThrows[Exception](exporter.`export`("Should throw exception"))
  }
}
