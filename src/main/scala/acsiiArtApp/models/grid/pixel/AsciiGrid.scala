package acsiiArtApp.models.grid.pixel

import acsiiArtApp.models.pixel.Pixel
import acsiiArtApp.models.pixel.ascii.ASCIIPixel

case class AsciiGrid (grid: Iterable[ASCIIPixel]) extends PixelGrid {
  override def foreach(func: Pixel => Unit): Unit = {
    grid.foreach(func)
  }
}
