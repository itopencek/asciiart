package asciiArtApp.models.pixel.rgb

import asciiArtApp.models.pixel.Pixel

case class RGBPixel(r: Int, g: Int, b: Int) extends Pixel {
  def getRGB(): Int = {
    r << 16 | g << 8 | b
  }
}
