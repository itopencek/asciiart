package asciiArtApp.console.outputs.image.specific

import exporters.text.concrete.FileOutputExporter

import java.io.File

/**
 * Outputs {@link asciiArtApp.models.image.grid.GreyscaleImage} to {@link File}.
 *
 * @param file {@link File} to output to
 */
class FileOutput(file: File) extends StreamTextOutput(new FileOutputExporter(file)) {

}
