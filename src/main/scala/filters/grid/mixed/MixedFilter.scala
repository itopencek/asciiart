package filters.grid.mixed

import asciiArtApp.models.grid.pixel.PixelGrid
import filters.grid.GridFilter

class MixedFilter(filters: Seq[GridFilter]) extends GridFilter {
  override def filter(item: PixelGrid): PixelGrid =
    filters.foldLeft(item)((accumulator, filter) => filter.filter(accumulator))
}
