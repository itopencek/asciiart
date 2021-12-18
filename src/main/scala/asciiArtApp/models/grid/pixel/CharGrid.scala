package asciiArtApp.models.grid.pixel

import asciiArtApp.models.pixel.char.GreyscalePixel

case class CharGrid(width: Int, grid: Seq[GreyscalePixel]) extends PixelGrid[GreyscalePixel] {
  def foreach(func: GreyscalePixel => Unit): Unit =
    grid.foreach(func)

  override def get(x: Int, y: Int): GreyscalePixel = {
    val pos = width * y + x

    grid(pos)
  }

  override def getGrid: Seq[GreyscalePixel] = grid
}
