package asciiArtApp.models.image.visitor

import asciiArtApp.models.image.grid.{GreyscaleImage}

/**
 * Visitor for {@link Image}.
 *
 * @tparam T type to return {@link Image} in
 */
trait ImageVisitor[T] {
  def visitGreyscaleImage(image: GreyscaleImage): T
}
