package models.grid.pixel

import models.grid.Grid
import models.pixel.Pixel

case class PixelGrid (grid: Iterable[Pixel]) extends Grid {
  def foreach(func: Pixel => Unit): Unit = {
    grid.foreach(func)
  }
}
