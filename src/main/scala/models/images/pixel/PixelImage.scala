package models.images.pixel

import models.grid.pixel.PixelGrid
import models.images.Image

// TODO maybe create trait GridImage
case class PixelImage (width: Int, height: Int, grid: PixelGrid) extends Image {

}
