package asciiArtApp.console.outputs.image.specific

import asciiArtApp.ImageTextRenderVisitor
import asciiArtApp.console.outputs.Output
import asciiArtApp.models.image.grid.GreyscaleImage
import exporters.text.concrete.StreamTextExporter

class StreamTextOutput(exporter: StreamTextExporter) extends Output[GreyscaleImage] {
  def visit(image: GreyscaleImage): String = new ImageTextRenderVisitor().visitAsciiImage(image)
  def export(item: String): Unit = exporter.`export`(item)

  override def output(item: GreyscaleImage): Unit = {
    export(visit(item))
  }
}
