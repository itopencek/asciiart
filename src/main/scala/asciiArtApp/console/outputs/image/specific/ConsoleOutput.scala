package asciiArtApp.console.outputs.image.specific

import exporters.text.concrete.StdOutputExporter

/**
 * Outputs {@link asciiArtApp.models.image.grid.GreyscaleImage} to console.
 */
class ConsoleOutput extends StreamTextOutput(new StdOutputExporter()) {

}
