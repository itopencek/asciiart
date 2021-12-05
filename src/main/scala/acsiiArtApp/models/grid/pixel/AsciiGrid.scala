package acsiiArtApp.models.grid.pixel

import acsiiArtApp.models.pixel.ascii.ASCIIPixel

case class AsciiGrid (grid: Iterable[ASCIIPixel]) extends PixelGrid[ASCIIPixel] {
  override def foreach(func: ASCIIPixel => Unit): Unit = {
    grid.foreach(func)
  }
}
