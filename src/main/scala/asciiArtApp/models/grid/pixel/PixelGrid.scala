package asciiArtApp.models.grid.pixel

import asciiArtApp.models.grid.Grid
import asciiArtApp.models.pixel.Pixel

trait PixelGrid extends Grid[Pixel] {
  def get(x: Int, y: Int): Pixel
}
