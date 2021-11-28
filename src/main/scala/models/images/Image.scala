package models.images

import models.Entity

trait Image extends Entity {

  def getHeight(): Int

  def getWidth(): Int
  // TODO
  def getData(): AnyRef
}
