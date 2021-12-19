package asciiArtApp.models.pixel.char

import asciiArtApp.models.pixel.Pixel

case class GreyscalePixel(character: Char, brightness: Int) extends Pixel {
  def setBrightness(value: Int): GreyscalePixel = {
    GreyscalePixel(character, value)
  }

  def getBrightness(): Int = {
    brightness
  }

  def getChar(): Char = character

  def get(): Char = character
}
