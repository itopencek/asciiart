package asciiArtApp.models.images.grid

import asciiArtApp.models.grid.pixel.CharGrid
import asciiArtApp.models.images.visitor.ImageVisitor
import asciiArtApp.models.pixel.Pixel
import asciiArtApp.models.pixel.char.CharPixel

case class CharImage(width: Int, height: Int, grid: CharGrid) extends PixelGridImage[CharPixel] {
  override def getHeight(): Int = height

  override def getWidth(): Int = width

  def getData(): CharGrid = grid.copy()

  def foreach(func: CharPixel => Unit): Unit = {
    grid.foreach(func)
  }

  override def accept[U](visitor: ImageVisitor[U]): U =
    visitor.visitAsciiImage(this)

  override def getPixel(x: Int, y: Int): Pixel = {
    grid.get(x, y)
  }
}
