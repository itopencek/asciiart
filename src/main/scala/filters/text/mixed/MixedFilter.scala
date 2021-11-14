package filters.text.mixed

import filters.text.TextFilter

class MixedFilter(filters: Seq[TextFilter]) extends TextFilter {
  override def filter(item: String): String =
    filters.foldLeft(item)((accumulator, filter) => filter.filter(accumulator))
}
