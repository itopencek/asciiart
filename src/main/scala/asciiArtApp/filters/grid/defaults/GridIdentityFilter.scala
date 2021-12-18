package asciiArtApp.filters.grid.defaults

import asciiArtApp.filters.defaults.IdentityFilter
import asciiArtApp.filters.grid.ImageFilter
import asciiArtApp.models.image.grid.GreyscaleImage

/**
 * Default {@link IdentityFilter} for {@link ImageFilter}. Used when user doesn't want any filters.
 */
class GridIdentityFilter extends IdentityFilter[GreyscaleImage] with ImageFilter {

}
