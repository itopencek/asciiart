package filters.grid.defaults

import asciiArtApp.models.grid.pixel.CharGrid
import filters.defaults.IdentityFilter
import filters.grid.GridFilter

class GridIdentityFilter extends IdentityFilter[CharGrid] with GridFilter {

}
