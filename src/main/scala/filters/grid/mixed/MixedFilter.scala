package filters.grid.mixed

import asciiArtApp.models.grid.pixel.CharGrid
import filters.grid.GridFilter

class MixedFilter(filters: Seq[GridFilter]) extends GridFilter {
  override def filter(item: CharGrid): CharGrid =
    filters.foldLeft(item)((accumulator, filter) => filter.filter(accumulator))
}
