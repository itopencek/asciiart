package asciiArtApp.models.pixel.char

import asciiArtApp.models.pixel.Pixel

case class GreyscalePixel(character: Char) extends Pixel {
  private var brightness: Int = 0

  def setBrightness(value: Int): Unit = {
    value match {
      case x if x > 255 => brightness = 255
      case x if x < 0 => brightness = 0
      case _ => brightness = value
    }
  }

  def getBrightness(): Int = {
    brightness
  }

  override def getInt(): Int = character.toInt

  def get(): Char = character
}
