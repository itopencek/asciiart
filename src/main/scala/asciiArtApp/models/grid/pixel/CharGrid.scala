package asciiArtApp.models.grid.pixel

import asciiArtApp.models.pixel.char.CharPixel

case class CharGrid(width: Int, pixels: Seq[CharPixel]) extends PixelGrid {
  def foreach(func: CharPixel => Unit): Unit =
    pixels.foreach(item => {
      func(item)
    })

  override def get(x: Int, y: Int): CharPixel = {
    if (x < 0 || y < 0) {
      throw new IndexOutOfBoundsException("Negative values for pixel.")
    }

    val pos = width * y + x

    pixels(pos)
  }

  override def getGrid: Seq[CharPixel] = pixels
}
