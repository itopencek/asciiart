package asciiArtApp.console.outputs.image.specific

import exporters.text.concrete.FileOutputExporter

import java.io.File

class FileOutput(file: File) extends StreamTextOutput(new FileOutputExporter(file)) {

}
