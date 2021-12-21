package asciiArtApp.console.outputs.image.specific

import asciiArtApp.ImageTextRenderVisitor
import asciiArtApp.console.outputs.image.ImageOutput
import asciiArtApp.models.image.grid.GreyscaleImage
import exporters.text.TextExporter

/**
 * Outputs {@link GreyscaleImage} to stream.
 *
 * @param exporter exporter type to use
 */
class ImageTextOutput(exporter: TextExporter) extends ImageOutput {
  def visit(image: GreyscaleImage): String = new ImageTextRenderVisitor().visitGreyscaleImage(image)
  def export(item: String): Unit = exporter.`export`(item)

  override def output(item: GreyscaleImage): Unit = {
    export(visit(item))
  }
}
