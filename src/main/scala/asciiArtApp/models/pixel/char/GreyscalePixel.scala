package asciiArtApp.models.pixel.char

import asciiArtApp.models.pixel.Pixel

case class GreyscalePixel(character: Char, brightness: Int) extends Pixel {
  def setBrightness(value: Int): GreyscalePixel = {
    GreyscalePixel(character, value)
  }

  def getBrightness(): Int = {
    brightness
  }

  override def getInt(): Int = character.toInt

  def get(): Char = character
}
