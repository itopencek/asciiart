package asciiArtApp.filters.image

import asciiArtApp.filters.Filter
import asciiArtApp.models.image.grid.GreyscaleImage

/**
 * Trait extending {@link Filter} for {@link GreyscaleImage}.
 */
trait ImageFilter extends Filter[GreyscaleImage] {
  override def filter(item: GreyscaleImage): GreyscaleImage
}
