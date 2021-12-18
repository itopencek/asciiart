package asciiArtApp.models.image.grid

import asciiArtApp.models.grid.pixel.GreyscaleGrid
import asciiArtApp.models.image.visitor.ImageVisitor
import asciiArtApp.models.pixel.char.GreyscalePixel

case class GreyscaleImage(width: Int, height: Int, grid: GreyscaleGrid) extends PixelGridImage {
  override def getHeight(): Int = height

  override def getWidth(): Int = width

  def getData(): GreyscaleGrid = grid.copy()

  def foreach(func: GreyscalePixel => Unit): Unit = {
    grid.foreach(func)
  }

  def accept[U](visitor: ImageVisitor[U]): U =
    visitor.visitGreyscaleImage(this)

  override def getPixel(x: Int, y: Int): GreyscalePixel = {
    grid.get(x, y)
  }

  def newImage(data: GreyscaleGrid): GreyscaleImage = {
    GreyscaleImage(width, height, data)
  }
}
