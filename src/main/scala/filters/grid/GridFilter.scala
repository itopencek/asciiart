package filters.grid

import filters.Filter
import acsiiArtApp.models.grid.pixel.PixelGrid

trait GridFilter extends Filter[PixelGrid] {
  override def filter(item: PixelGrid): PixelGrid
}
