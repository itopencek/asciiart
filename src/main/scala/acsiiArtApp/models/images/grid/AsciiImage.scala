package acsiiArtApp.models.images.grid

import acsiiArtApp.models.grid.pixel.AsciiGrid
import acsiiArtApp.models.images.visitor.ImageVisitor
import acsiiArtApp.models.pixel.Pixel
import acsiiArtApp.models.pixel.ascii.ASCIIPixel

case class AsciiImage(width: Int, height: Int, grid: AsciiGrid) extends PixelGridImage[ASCIIPixel] {
  override def getHeight(): Int = height

  override def getWidth(): Int = width

  override def getData(): AsciiGrid = grid

  def foreach(func: Pixel => Unit): Unit = {
    grid.foreach(func)
  }

  override def accept[U](visitor: ImageVisitor[U]): U =
    visitor.visitAsciiImage(this)
}
