package asciiArtApp.models.grid.pixel

import asciiArtApp.models.pixel.char.CharPixel

case class CharGrid(width: Int, grid: Seq[CharPixel]) extends PixelGrid[CharPixel] {
  def foreach(func: CharPixel => Unit): Unit =
    grid.foreach(func)

  override def get(x: Int, y: Int): CharPixel = {
    val pos = width * y + x

    grid(pos)
  }
}
