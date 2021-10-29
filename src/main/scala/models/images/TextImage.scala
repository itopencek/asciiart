package models.images

trait TextImage extends Image {
  def withId(newId: Int): TextImage
}
