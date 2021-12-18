package asciiArtApp.models.grid.pixel

import asciiArtApp.models.pixel.rgb.RGBPixel

case class RgbGrid(width: Int, grid: Seq[RGBPixel]) extends PixelGrid {
  def foreach(func: RGBPixel => Unit): Unit = {
    grid.foreach(func)
  }

  override def get(x: Int, y: Int): RGBPixel = {
    val pos = width * y + x

    grid(pos)
  }

  override def getGrid: Seq[RGBPixel] = grid
}
