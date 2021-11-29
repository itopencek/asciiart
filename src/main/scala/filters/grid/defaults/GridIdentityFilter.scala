package filters.grid.defaults

import filters.defaults.IdentityFilter
import filters.grid.GridFilter
import acsiiArtApp.models.grid.Grid

class GridIdentityFilter extends IdentityFilter[Grid] with GridFilter {

}
