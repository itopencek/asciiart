package models.images.buffer
import models.images.Image

case class IntBufferImage(id: Int, width: Int, height: Int, buffer: Array[Array[Int]]) extends BufferImage[Int] {
  override def getBuffer(): Array[Array[Int]] = buffer

  override def withId(newId: Int): Image = IntBufferImage(newId, width, height, buffer)
}
