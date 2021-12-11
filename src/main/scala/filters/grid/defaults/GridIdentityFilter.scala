package filters.grid.defaults

import asciiArtApp.models.grid.pixel.PixelGrid
import filters.defaults.IdentityFilter
import filters.grid.GridFilter

class GridIdentityFilter extends IdentityFilter[PixelGrid] with GridFilter {

}
