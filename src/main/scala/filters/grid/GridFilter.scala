package filters.grid

import asciiArtApp.models.grid.pixel.GreyscaleGrid
import filters.Filter

trait GridFilter extends Filter[GreyscaleGrid] {
  override def filter(item: GreyscaleGrid): GreyscaleGrid
}
