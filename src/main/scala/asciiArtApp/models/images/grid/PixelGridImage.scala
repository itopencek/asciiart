package asciiArtApp.models.images.grid

import asciiArtApp.models.grid.pixel.PixelGrid
import asciiArtApp.models.images.Image
import asciiArtApp.models.pixel.Pixel

trait PixelGridImage[T] extends Image[PixelGrid[T]] {
  def getPixel(x: Int, y: Int): Pixel
}
