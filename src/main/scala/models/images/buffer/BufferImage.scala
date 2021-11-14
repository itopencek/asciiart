package models.images.buffer

import models.images.Image

trait BufferImage[T] extends Image {
  def getBuffer(): Array[Array[T]]
}
