package filters.grid.mixed

import filters.grid.GridFilter
import acsiiArtApp.models.grid.Grid

class MixedFilter(filters: Seq[GridFilter]) extends GridFilter {
  override def filter(item: Grid): Grid =
    filters.foldLeft(item)((accumulator, filter) => filter.filter(accumulator))
}
