package acsiiArtApp.models.images.grid

import acsiiArtApp.models.grid.pixel.PixelGrid
import acsiiArtApp.models.images.visitor.ImageVisitor
import acsiiArtApp.models.pixel.Pixel

case class PixelImage (width: Int, height: Int, grid: PixelGrid) extends GridImage {
  override def getHeight(): Int = height

  override def getWidth(): Int = width

  override def getData(): PixelGrid = grid

  def foreach(func: Pixel => Unit): Unit = {
    grid.foreach(func)
  }

  override def accept[U](visitor: ImageVisitor[U]): U =
    visitor.visitPixelImage(this)
}
