package asciiArtApp.filters.grid.specific

import asciiArtApp.convertors.image.pixel.ToAsciiPixelConvertor
import asciiArtApp.filters.grid.ImageFilter
import asciiArtApp.models.grid.pixel.GreyscaleGrid
import asciiArtApp.models.image.grid.GreyscaleImage
import asciiArtApp.models.pixel.char.GreyscalePixel

import scala.collection.mutable.ArrayBuffer

class InvertFilter extends ImageFilter {
  def convert(value: Int): GreyscalePixel = new ToAsciiPixelConvertor().convert(value)

  override def filter(item: GreyscaleImage): GreyscaleImage = {
    val data = ArrayBuffer[GreyscalePixel]()
    item.foreach(pixel => {
      data.append(convert(255 - pixel.getBrightness()))
    })

    item.newImage(GreyscaleGrid(item.getWidth(), data.toArray[GreyscalePixel]))
  }
}
