package filters.grid

import asciiArtApp.models.images.grid.GreyscaleImage
import filters.Filter

trait GridFilter extends Filter[GreyscaleImage] {
  override def filter(item: GreyscaleImage): GreyscaleImage
}
