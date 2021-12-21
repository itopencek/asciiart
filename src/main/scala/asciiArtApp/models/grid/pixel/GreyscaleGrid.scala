package asciiArtApp.models.grid.pixel

import asciiArtApp.models.pixel.char.GreyscalePixel

case class GreyscaleGrid(width: Int, pixels: Seq[GreyscalePixel]) extends PixelGrid {
  def foreach(func: GreyscalePixel => Unit): Unit =
    pixels.foreach(item => {
      val copied = item.copy()
      func(copied)
    })

  override def get(x: Int, y: Int): GreyscalePixel = {
    if (x < 0 || y < 0) {
      throw new IndexOutOfBoundsException("Negative values for pixel.")
    }

    val pos = width * y + x

    pixels(pos).copy()
  }

  override def getGrid: Seq[GreyscalePixel] = pixels
}
