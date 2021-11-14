package models.images

case class StringImage(id: Int, data: String) extends PixelImage {
  override def withId(newId: Int): StringImage = {
    StringImage(newId, data)
  }
}
