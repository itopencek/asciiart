package exporters.text.concrete

import exporters.text.TextExporter

import java.io.OutputStream

/**
 * Exports text to {@link OutputStream}.
 *
 * @param outputStream {@link OutputStream} to export text to
 */
class StreamTextExporter(outputStream: OutputStream) extends TextExporter
{
  private var closed = false

  protected def exportToStream(text: String): Unit ={

    if (closed)
      throw new Exception("The stream is already closed")

    outputStream.write(text.getBytes("UTF-8"))
    outputStream.flush()
  }

  /**
   * Close {@link OutputStream}.
   */
  def close(): Unit = {
    if (closed)
      return

    outputStream.close()
    closed = true
  }

  /**
   * Exports item.
   *
   * @param item {@link String} to export
   */
  override def export(item: String): Unit = exportToStream(item)
}
