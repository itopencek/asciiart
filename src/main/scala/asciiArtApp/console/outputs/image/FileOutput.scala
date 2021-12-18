package asciiArtApp.console.outputs.image

import exporters.text.concrete.FileOutputExporter

import java.io.File

class FileOutput(file: File) extends ImageOutput(new FileOutputExporter(file)) {

}
