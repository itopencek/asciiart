package acsiiArtApp.models.images.visitor

import acsiiArtApp.models.images.grid.{AsciiImage, RgbImage}

trait ImageVisitor[T] {
  def visitAsciiImage(image: AsciiImage): T
  def visitRgbImage(image: RgbImage): T
}
