package models.images

case class PNGImage(id: Int) extends PixelImage {
  override def withId(newId: Int): PNGImage = {
    PNGImage(newId)
  }
}
