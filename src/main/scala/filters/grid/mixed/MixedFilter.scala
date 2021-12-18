package filters.grid.mixed

import asciiArtApp.models.grid.pixel.GreyscaleGrid
import filters.grid.GridFilter

class MixedFilter(filters: Seq[GridFilter]) extends GridFilter {
  override def filter(item: GreyscaleGrid): GreyscaleGrid =
    filters.foldLeft(item)((accumulator, filter) => filter.filter(accumulator))
}
