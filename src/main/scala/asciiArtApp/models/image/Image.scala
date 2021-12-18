package asciiArtApp.models.image

import asciiArtApp.models.Entity
import asciiArtApp.models.image.visitor.ImageVisitor

trait Image[T] extends Entity {

  def getHeight(): Int

  def getWidth(): Int
}
