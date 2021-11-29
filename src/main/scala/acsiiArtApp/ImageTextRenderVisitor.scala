package acsiiArtApp

import acsiiArtApp.models.images.grid.PixelImage
import acsiiArtApp.models.images.visitor.ImageVisitor

class ImageTextRenderVisitor extends ImageVisitor[String] {
  override def visitPixelImage(image: PixelImage): String = {
    var response = ""
    var num = 0

    image.foreach(pixel =>
    {
      response += pixel.getInt()

      if (num % image.getWidth() == 0 && num != 0) {
        response += "\n"
      }
      num += 1
    })

    response
  }
}
