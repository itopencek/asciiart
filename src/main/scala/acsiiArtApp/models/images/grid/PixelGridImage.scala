package acsiiArtApp.models.images.grid

import acsiiArtApp.models.grid.pixel.PixelGrid
import acsiiArtApp.models.pixel.Pixel

trait PixelGridImage[T <: Pixel] extends GridImage[PixelGrid[T]] {

}
