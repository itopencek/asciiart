package acsiiArtApp.models.grid.pixel

import acsiiArtApp.models.pixel.Pixel
import acsiiArtApp.models.pixel.rgb.RGBPixel

case class RgbGrid (grid: Iterable[RGBPixel]) extends PixelGrid {
  override def foreach(func: Pixel => Unit): Unit = {
    grid.foreach(func)
  }
}
