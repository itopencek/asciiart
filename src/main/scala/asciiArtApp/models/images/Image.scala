package asciiArtApp.models.images

import asciiArtApp.models.Entity
import asciiArtApp.models.images.visitor.ImageVisitor

trait Image[T] extends Entity {

  def getHeight(): Int

  def getWidth(): Int

  def getData(): T

  def accept[U](visitor: ImageVisitor[U]): U
}
