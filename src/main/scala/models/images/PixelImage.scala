package models.images

trait PixelImage extends Image {
  def withId(newId: Int): PixelImage
}
