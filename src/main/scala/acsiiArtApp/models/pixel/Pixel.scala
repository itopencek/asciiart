package acsiiArtApp.models.pixel

import acsiiArtApp.models.Entity

trait Pixel extends Entity {
  // Int representation of pixel
  def getInt(): Int
}
