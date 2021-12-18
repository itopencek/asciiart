package asciiArtApp.models.images.visitor

import asciiArtApp.models.images.grid.{GreyscaleImage, RgbImage}

trait ImageVisitor[T] {
  def visitAsciiImage(image: GreyscaleImage): T
  def visitRgbImage(image: RgbImage): T
}
