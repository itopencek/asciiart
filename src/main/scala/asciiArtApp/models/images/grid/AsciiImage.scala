package asciiArtApp.models.images.grid

import asciiArtApp.models.grid.pixel.AsciiGrid
import asciiArtApp.models.images.visitor.ImageVisitor
import asciiArtApp.models.pixel.Pixel

case class AsciiImage(width: Int, height: Int, grid: AsciiGrid) extends PixelGridImage {
  override def getHeight(): Int = height

  override def getWidth(): Int = width

  override def getData(): AsciiGrid = grid.copy()

  def foreach(func: Pixel => Unit): Unit = {
    grid.foreach(func)
  }

  override def accept[U](visitor: ImageVisitor[U]): U =
    visitor.visitAsciiImage(this)

  override def getPixel(x: Int, y: Int): Pixel = {
    grid.get(x, y)
  }
}
