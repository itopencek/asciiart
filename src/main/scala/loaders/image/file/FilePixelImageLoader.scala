package loaders.image.file

import loaders.image.PixelImageLoader
import acsiiArtApp.models.grid.pixel.PixelGrid
import acsiiArtApp.models.images.grid.AsciiImage
import acsiiArtApp.models.pixel.Pixel
import acsiiArtApp.models.pixel.rgb.RGBPixel

import java.io.File
import javax.imageio.ImageIO

class FilePixelImageLoader extends PixelImageLoader[String] {
  override def load(source: String): AsciiImage = {
    val img = ImageIO.read(new File(source))
    val width = img.getWidth
    val height = img.getHeight
    val data = Array.ofDim[Pixel](width * height)

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

    AsciiImage(width, height, PixelGrid(data))
  }
}
