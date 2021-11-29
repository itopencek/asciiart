package acsiiArtApp.models.images

import acsiiArtApp.models.Entity

trait Image[T] extends Entity {

  def getHeight(): Int

  def getWidth(): Int

  def getData(): T
}
