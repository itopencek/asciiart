package acsiiArtApp.models.images.grid

import acsiiArtApp.models.grid.pixel.RgbGrid
import acsiiArtApp.models.images.visitor.ImageVisitor
import acsiiArtApp.models.pixel.Pixel

case class RgbImage(width: Int, height: Int, grid: RgbGrid) extends PixelGridImage {
  override def getHeight(): Int = height

  override def getWidth(): Int = width

  override def getData(): RgbGrid = grid

  def foreach(func: Pixel => Unit): Unit = {
    grid.foreach(func)
  }

  override def accept[U](visitor: ImageVisitor[U]): U =
    visitor.visitRgbImage(this)

  override def getPixel(x: Int, y: Int): Pixel = {
    grid.get(x, y)
  }
}
