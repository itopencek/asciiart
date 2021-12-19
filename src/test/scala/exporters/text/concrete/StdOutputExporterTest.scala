package exporters.text.concrete

import org.scalatest.FunSuite

class StdOutputExporterTest extends FunSuite {
  test("Test export text") {
    val exporter = new StdOutputExporter()
    exporter.`export`("Test string \n asd")
    exporter.`export`("text2")
    exporter.close()
  }
}
