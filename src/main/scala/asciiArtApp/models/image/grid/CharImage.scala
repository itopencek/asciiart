package asciiArtApp.models.image.grid

import asciiArtApp.models.grid.pixel.CharGrid
import asciiArtApp.models.pixel.Pixel
import asciiArtApp.models.pixel.char.CharPixel

case class CharImage(width: Int, height: Int, grid: CharGrid) extends PixelGridImage {
  def foreach(func: CharPixel => Unit): Unit = {
    grid.foreach(func)
  }

  override def getPixel(x: Int, y: Int): Pixel = grid.get(x, y)

  override def getHeight(): Int = height

  override def getWidth(): Int = width
}
