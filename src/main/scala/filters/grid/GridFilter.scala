package filters.grid

import filters.Filter
import acsiiArtApp.models.grid.Grid

trait GridFilter extends Filter[Grid] {
  override def filter(item: Grid): Grid
}
