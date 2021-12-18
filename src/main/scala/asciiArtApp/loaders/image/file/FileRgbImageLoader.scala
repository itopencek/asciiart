package asciiArtApp.loaders.image.file

import asciiArtApp.loaders.image.RgbImageLoader
import asciiArtApp.models.grid.pixel.RgbGrid
import asciiArtApp.models.image.grid.RgbImage
import asciiArtApp.models.pixel.rgb.RGBPixel

import java.io.File
import javax.imageio.ImageIO
import scala.collection.mutable.ArrayBuffer

class FileRgbImageLoader(source: String) extends RgbImageLoader {
  override def load(): RgbImage = {
    val img = ImageIO.read(new File(source))
    val width = img.getWidth
    val height = img.getHeight
    val data = new ArrayBuffer[RGBPixel]()

    // we read by rows
    for (i <- 0 until height) {
      for (j <- 0 until width) {
        val rgb = img.getRGB(j, i)
        // convert to separate values
        val r = (rgb >> 16) & 0xFF
        val g = (rgb >> 8) & 0xFF
        val b = (rgb >> 0) & 0xFF

        data.append(RGBPixel(r, g, b))
      }
    }

    RgbImage(width, height, RgbGrid(width, data.toArray[RGBPixel]))
  }
}
