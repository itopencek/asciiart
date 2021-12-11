package asciiArtApp.models.images.visitor

import asciiArtApp.models.images.grid.{AsciiImage, RgbImage}

trait ImageVisitor[T] {
  def visitAsciiImage(image: AsciiImage): T
  def visitRgbImage(image: RgbImage): T
}
