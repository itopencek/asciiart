package asciiArtApp.console.outputs.image

import exporters.text.concrete.StdOutputExporter

class ConsoleOutput extends ImageOutput(new StdOutputExporter()) {
}
