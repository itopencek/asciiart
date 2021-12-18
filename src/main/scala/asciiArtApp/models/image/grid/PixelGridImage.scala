package asciiArtApp.models.image.grid

import asciiArtApp.models.grid.pixel.PixelGrid
import asciiArtApp.models.image.Image
import asciiArtApp.models.pixel.Pixel

trait PixelGridImage extends Image[PixelGrid] {
  def getPixel(x: Int, y: Int): Pixel
}
