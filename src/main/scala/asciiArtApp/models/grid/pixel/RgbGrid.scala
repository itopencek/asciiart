package asciiArtApp.models.grid.pixel

import asciiArtApp.models.pixel.rgb.RGBPixel

case class RgbGrid(width: Int, pixels: Seq[RGBPixel]) extends PixelGrid {
  def foreach(func: RGBPixel => Unit): Unit = {
    pixels.foreach(func)
  }

  override def get(x: Int, y: Int): RGBPixel = {
    if (x < 0 || y < 0) {
      throw new IndexOutOfBoundsException("Negative values for pixel.")
    }

    val pos = width * y + x

    pixels(pos)
  }

  override def getGrid: Seq[RGBPixel] = pixels
}
