package models.images

case class ASCIIImage(id: Int) extends TextImage {
  override def withId(newId: Int): ASCIIImage = {
    ASCIIImage(newId)
  }
}
