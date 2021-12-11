package asciiArtApp.models.pixel.ascii

import asciiArtApp.models.pixel.Pixel

case class ASCIIPixel (character: Char) extends Pixel {
  override def getInt(): Int = character.toInt
}
