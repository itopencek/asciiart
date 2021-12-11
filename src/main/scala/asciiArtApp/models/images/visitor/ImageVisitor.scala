package asciiArtApp.models.images.visitor

import asciiArtApp.models.images.grid.{CharImage, RgbImage}

trait ImageVisitor[T] {
  def visitAsciiImage(image: CharImage): T
  def visitRgbImage(image: RgbImage): T
}
