package asciiArtApp.filters.defaults

import asciiArtApp.filters.Filter

/**
 * Identity {@link Filter} - doesn't change item.
 * @tparam T type
 */
class IdentityFilter[T] extends Filter[T] {
  /**
   * Filter, which doesn't change anything.
   *
   * @param item to filter
   * @return unchanged item
   */
  override def filter(item: T): T = item
}
