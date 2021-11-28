package exporters.image.ascii

import java.io.{File, FileOutputStream}

class FileOutputExporter(file: File) extends StreamImageExporter(new FileOutputStream(file)) {

}
