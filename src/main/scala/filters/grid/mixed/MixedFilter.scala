package filters.grid.mixed

import filters.grid.GridFilter
import acsiiArtApp.models.grid.pixel.PixelGrid

class MixedFilter(filters: Seq[GridFilter]) extends GridFilter {
  override def filter(item: PixelGrid): PixelGrid =
    filters.foldLeft(item)((accumulator, filter) => filter.filter(accumulator))
}
