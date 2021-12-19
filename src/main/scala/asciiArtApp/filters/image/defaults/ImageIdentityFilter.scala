package asciiArtApp.filters.image.defaults

import asciiArtApp.filters.defaults.IdentityFilter
import asciiArtApp.filters.image.ImageFilter
import asciiArtApp.models.image.grid.GreyscaleImage

/**
 * Default {@link IdentityFilter} for {@link ImageFilter}.
 * <p>
 * Note: Used when user doesn't want any filters.
 * </p>
 */
class ImageIdentityFilter extends IdentityFilter[GreyscaleImage] with ImageFilter {

}
