package asciiArtApp.models.images.grid

import asciiArtApp.models.grid.pixel.RgbGrid
import asciiArtApp.models.images.visitor.ImageVisitor
import asciiArtApp.models.pixel.Pixel
import asciiArtApp.models.pixel.char.GreyscalePixel
import asciiArtApp.models.pixel.rgb.RGBPixel

case class RgbImage(width: Int, height: Int, grid: RgbGrid) extends PixelGridImage[GreyscalePixel] {
  override def getHeight(): Int = height

  override def getWidth(): Int = width

  def getData(): RgbGrid = grid

  def foreach(func: RGBPixel => Unit): Unit = {
    grid.foreach(func)
  }

  override def accept[U](visitor: ImageVisitor[U]): U =
    visitor.visitRgbImage(this)

  override def getPixel(x: Int, y: Int): Pixel = {
    grid.get(x, y)
  }
}
