package asciiArtApp.models.pixel

import asciiArtApp.models.Entity

trait Pixel extends Entity {
  // Int representation of pixel
  def getInt(): Int
}
