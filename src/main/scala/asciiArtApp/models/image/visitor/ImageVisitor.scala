package asciiArtApp.models.image.visitor

import asciiArtApp.models.image.grid.{GreyscaleImage, RgbImage}

trait ImageVisitor[T] {
  def visitAsciiImage(image: GreyscaleImage): T
  def visitRgbImage(image: RgbImage): T
}
