package asciiArtApp.loaders.image.file

import asciiArtApp.loaders.image.RgbImageLoader
import asciiArtApp.models.grid.pixel.RgbGrid
import asciiArtApp.models.image.grid.RgbImage
import asciiArtApp.models.pixel.rgb.RGBPixel

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.{IIOException, ImageIO}
import scala.collection.mutable.ArrayBuffer

/**
 * Loads {@link RgbImage} from given {@link String} path.
 *
 * @param source {@link String} path to load {@link RgbImage} from
 */
abstract class FileRgbImageLoader extends RgbImageLoader {
  /**
   * Loads {@link RgbImage} from {@link BufferedImage}.
   *
   * @param img {@link BufferedImage} to load
   * @return {@link RgbImage} loaded
   */
  protected def handleImage(img: BufferedImage): RgbImage = {
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

        if (r > 255 | g > 255 | b > 255) {
          throw new IndexOutOfBoundsException("Error loading RGB pixel.")
        }

        data.append(RGBPixel(r, g, b))
      }
    }

    RgbImage(width, height, RgbGrid(width, data.toArray[RGBPixel]))
  }

  /**
   * Reads image from given path. Implementation for JPG, PNG and BMP formats.
   *
   * @param path {@link String} path to image
   * @return {@link BufferedImage} loaded universal format
   * @throws {@link IllegalArgumentException} when path can't be read
   */
  protected def readImage(path: String): BufferedImage = {
    try {
      ImageIO.read(new File(path))
    } catch {
      case e: IIOException => throw new IllegalArgumentException("Can't read path. " + e.toString)
    }
  }
}
