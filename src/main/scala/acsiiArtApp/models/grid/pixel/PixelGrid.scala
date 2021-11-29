package acsiiArtApp.models.grid.pixel

import acsiiArtApp.models.grid.Grid
import acsiiArtApp.models.pixel.Pixel

case class PixelGrid (grid: Iterable[Pixel]) extends Grid {
  def foreach(func: Pixel => Unit): Unit = {
    grid.foreach(func)
  }
}
