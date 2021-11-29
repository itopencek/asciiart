package exporters.image.ascii

import exporters.image.ImageExporter
import acsiiArtApp.models.images.grid.PixelImage

import java.io.OutputStream

class StreamImageExporter(outputStream: OutputStream) extends ImageExporter {
  private var closed = false
  private val NEW_LINE = 10

  override def export(item: PixelImage): Unit = {
    if (closed)
      throw new Exception("The stream is already closed")

    var num = 0
    item.foreach(pixel =>
      {
        outputStream.write(pixel.getInt())

        if (num % item.getWidth() == 0 && num != 0) {
          outputStream.write(NEW_LINE)
        }
        num += 1
      })
    outputStream.flush()
  }

  def close(): Unit = {
    if (closed)
      return

    outputStream.close()
    closed = true

  }
}
