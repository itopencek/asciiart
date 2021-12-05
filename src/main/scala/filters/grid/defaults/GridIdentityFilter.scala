package filters.grid.defaults

import filters.defaults.IdentityFilter
import filters.grid.GridFilter
import acsiiArtApp.models.grid.pixel.PixelGrid

class GridIdentityFilter extends IdentityFilter[PixelGrid] with GridFilter {

}
