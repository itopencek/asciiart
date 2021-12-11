package asciiArtApp.models.grid.pixel

import asciiArtApp.models.pixel.Pixel
import asciiArtApp.models.pixel.char.CharPixel

case class CharGrid(width: Int, grid: Iterable[CharPixel]) extends PixelGrid[CharPixel] {
  override def foreach(func: CharPixel => Unit): Unit = {
    grid.foreach(func)
  }

  override def get(x: Int, y: Int): Pixel = {
    val pos = width * y + x

    grid.slice(pos, pos + 1).head.copy()
  }
}
