package loaders.image.file
import models.images.buffer.IntBufferImage

import javax.imageio.ImageIO
import java.io.File

class FileIntBufferImageLoader extends FileBufferImageLoader[Int] {
  override def load(source: String): IntBufferImage = {
    val img = ImageIO.read(new File(source))
    val width = img.getWidth
    val height = img.getHeight
    val data = Array.ofDim[Int](width, height)

    for (i <- 0 to width) {
      for (j <- 0 to height) {
        data(i)(j) = img.getRGB(i, j)
      }
    }

    IntBufferImage(0, width, height, data)
  }
}
