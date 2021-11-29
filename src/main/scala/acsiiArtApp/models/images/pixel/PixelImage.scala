package acsiiArtApp.models.images.pixel

import acsiiArtApp.models.grid.pixel.PixelGrid
import acsiiArtApp.models.images.Image
import acsiiArtApp.models.pixel.Pixel

// TODO maybe create trait GridImage
case class PixelImage (width: Int, height: Int, grid: PixelGrid) extends Image {
  override def getHeight(): Int = height

  override def getWidth(): Int = width

  override def getData(): PixelGrid = grid

  def foreach(func: Pixel => Unit): Unit = {
    grid.foreach(func)
  }
}
