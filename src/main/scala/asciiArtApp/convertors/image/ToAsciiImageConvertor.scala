package asciiArtApp.convertors.image
import asciiArtApp.convertors.image.pixel.ToAsciiPixelConvertor
import asciiArtApp.models.grid.pixel.GreyscaleGrid
import asciiArtApp.models.images.grid.{CharImage, RgbImage}
import asciiArtApp.models.pixel.char.GreyscalePixel
import asciiArtApp.models.pixel.rgb.RGBPixel

import scala.collection.mutable.ArrayBuffer

class ToAsciiImageConvertor extends ImageConvertor {
  private def pixelConvertor = new ToAsciiPixelConvertor
  private def convert(pixel: RGBPixel): GreyscalePixel = pixelConvertor.convert(pixel)

  override def convert(item: RgbImage): CharImage = {
    val width = item.getWidth()
    val data = new ArrayBuffer[GreyscalePixel]()
    item.foreach(pixel => data.append(convert(pixel)))

    CharImage(width, item.getHeight(), GreyscaleGrid(width, data.toArray[GreyscalePixel]))
  }
}
