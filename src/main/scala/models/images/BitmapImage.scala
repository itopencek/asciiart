package models.images

case class BitmapImage(id: Int) extends PixelImage {
  override def withId(newId: Int): BitmapImage = {
    BitmapImage(newId)
  }
}
