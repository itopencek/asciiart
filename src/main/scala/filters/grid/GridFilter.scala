package filters.grid

import asciiArtApp.models.grid.pixel.CharGrid
import filters.Filter

trait GridFilter extends Filter[CharGrid] {
  override def filter(item: CharGrid): CharGrid
}
