package filters.grid

import asciiArtApp.models.grid.pixel.PixelGrid
import filters.Filter

trait GridFilter extends Filter[PixelGrid] {
  override def filter(item: PixelGrid): PixelGrid
}
