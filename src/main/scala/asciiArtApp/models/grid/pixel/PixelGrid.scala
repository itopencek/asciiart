package asciiArtApp.models.grid.pixel

import asciiArtApp.models.grid.Grid
import asciiArtApp.models.pixel.Pixel

trait PixelGrid[T] extends Grid[Pixel] {
  def foreach(func: T => Unit): Unit

  def getGrid: Seq[Pixel]
}
