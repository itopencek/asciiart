package acsiiArtApp.models.grid.pixel

import acsiiArtApp.models.pixel.rgb.RGBPixel

case class RgbGrid (grid: Iterable[RGBPixel]) extends PixelGrid[RGBPixel] {
  override def foreach(func: RGBPixel => Unit): Unit = {
    grid.foreach(func)
  }
}
