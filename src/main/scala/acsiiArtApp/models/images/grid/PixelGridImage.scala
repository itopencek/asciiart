package acsiiArtApp.models.images.grid

import acsiiArtApp.models.grid.pixel.PixelGrid
import acsiiArtApp.models.images.Image
import acsiiArtApp.models.pixel.Pixel

trait PixelGridImage extends Image[PixelGrid] {
  def getPixel(x: Int, y: Int): Pixel
}
