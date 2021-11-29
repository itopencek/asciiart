package acsiiArtApp.models.images.visitor

import acsiiArtApp.models.images.grid.PixelImage

trait ImageVisitor[T] {
  def visitPixelImage(image: PixelImage): T
}
