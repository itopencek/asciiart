package acsiiArtApp.models.grid.pixel

import acsiiArtApp.models.grid.Grid
import acsiiArtApp.models.pixel.Pixel

trait PixelGrid extends Grid[Pixel] {
  def get(x: Int, y: Int): Pixel
}
