package acsiiArtApp.models.pixel.ascii

import acsiiArtApp.models.pixel.Pixel

case class ASCIIPixel (character: Char) extends Pixel {
  override def getInt(): Int = character.toInt
}
