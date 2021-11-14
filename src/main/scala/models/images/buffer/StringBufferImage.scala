package models.images.buffer

case class StringBufferImage(id: Int, width: Int, height: Int, buffer: Array[Array[String]])
  extends BufferImage[String] {
  override def withId(newId: Int): StringBufferImage =
    StringBufferImage(newId, width, height, buffer)

  override def getBuffer(): Array[Array[String]] = buffer
}
