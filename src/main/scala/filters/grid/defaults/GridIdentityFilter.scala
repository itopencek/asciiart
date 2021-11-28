package filters.grid.defaults

import filters.defaults.IdentityFilter
import filters.grid.GridFilter
import models.grid.Grid

class GridIdentityFilter extends IdentityFilter[Grid] with GridFilter {

}
