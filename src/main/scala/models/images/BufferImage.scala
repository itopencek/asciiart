package models.images

import java.awt.image.BufferedImage

case class BufferImage (id: Int, data: BufferedImage) extends PixelImage {
  override def withId(newId: Int): BufferImage = {
    BufferImage(newId, data)
  }
}
