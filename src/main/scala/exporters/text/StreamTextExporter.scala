package exporters.text

import java.io.OutputStream

class StreamTextExporter(outputStream: OutputStream) extends TextExporter {
  override def export(item: String): Unit = ???
}
