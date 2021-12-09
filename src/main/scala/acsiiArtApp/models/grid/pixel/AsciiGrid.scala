package acsiiArtApp.models.grid.pixel

import acsiiArtApp.models.pixel.Pixel
import acsiiArtApp.models.pixel.ascii.ASCIIPixel

case class AsciiGrid (width: Int, grid: Iterable[ASCIIPixel]) extends PixelGrid {
  override def foreach(func: Pixel => Unit): Unit = {
    grid.foreach(func)
  }

  override def get(x: Int, y: Int): Pixel = {
    val pos = width * y + x

    grid.slice(pos, pos + 1).head
  }
}
