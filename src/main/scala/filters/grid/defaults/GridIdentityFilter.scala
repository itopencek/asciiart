package filters.grid.defaults

import asciiArtApp.models.grid.pixel.GreyscaleGrid
import filters.defaults.IdentityFilter
import filters.grid.GridFilter

class GridIdentityFilter extends IdentityFilter[GreyscaleGrid] with GridFilter {

}
