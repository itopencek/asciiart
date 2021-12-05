package acsiiArtApp.models.grid.pixel

import acsiiArtApp.models.grid.Grid
import acsiiArtApp.models.pixel.Pixel

trait PixelGrid[T <: Pixel] extends Grid {
  def foreach(func: T => Unit): Unit
}
