package acsiiArtApp.models.grid.pixel

import acsiiArtApp.models.pixel.Pixel
import acsiiArtApp.models.pixel.rgb.RGBPixel

case class RgbGrid(width: Int, grid: Iterable[RGBPixel]) extends PixelGrid {
  override def foreach(func: Pixel => Unit): Unit = {
    grid.foreach(func)
  }

  override def get(x: Int, y: Int): Pixel = {
    val pos = width * y + x

    grid.slice(pos, pos + 1).head
  }
}
