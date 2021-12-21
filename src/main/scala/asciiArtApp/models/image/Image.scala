package asciiArtApp.models.image

import asciiArtApp.models.Entity

trait Image[T] extends Entity {

  def getHeight(): Int

  def getWidth(): Int
}
