package asciiArtApp.console.outputs.image.specific

import asciiArtApp.console.outputs.image.ImageOutput
import asciiArtApp.models.image.grid.CharImage
import exporters.text.TextExporter

/**
 * Outputs {@link CharImage} to {@link TextExporter}.
 *
 * @param exporter type of {@link TextExporter} to use
 */
class ImageTextOutput(exporter: TextExporter) extends ImageOutput {
  def export(item: String): Unit = exporter.`export`(item)

  /**
   * Outputs {@link CharImage} to {@link TextExporter}.
   *
   * @param item {@link CharImage to export}
   */
  override def output(item: CharImage): Unit = {
    var response = ""
    var num = 0

    item.foreach(pixel =>
    {
      response += pixel.character
      num += 1

      if (num % item.getWidth() == 0) {
        response += "\n"
      }
    })

    export(response)
  }
}
