package loaders.image.file

import acsiiArtApp.models.grid.pixel.RgbGrid
import loaders.image.RgbImageLoader
import acsiiArtApp.models.images.grid.RgbImage
import acsiiArtApp.models.pixel.rgb.RGBPixel

import java.io.File
import javax.imageio.ImageIO

class FileRgbImageLoader extends RgbImageLoader[String] {
  override def load(source: String): RgbImage = {
    val img = ImageIO.read(new File(source))
    val width = img.getWidth
    val height = img.getHeight
    val data = Array.ofDim[RGBPixel](width * height)

    // we read by rows
    for (i <- 0 to height) {
      for (j <- 0 to width) {
        val rgb = img.getRGB(j, i)
        // convert to separate values
        val r = (rgb >> 16) & 0xFF
        val g = (rgb >> 8) & 0xFF
        val b = (rgb >> 0) & 0xFF

        data :+ RGBPixel(r, g, b)
      }
    }

    RgbImage(width, height, RgbGrid(data))
  }
}
