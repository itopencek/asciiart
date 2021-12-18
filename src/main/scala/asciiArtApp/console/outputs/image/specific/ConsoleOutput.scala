package asciiArtApp.console.outputs.image.specific

import exporters.text.concrete.StdOutputExporter

class ConsoleOutput extends StreamTextOutput(new StdOutputExporter()) {
}
