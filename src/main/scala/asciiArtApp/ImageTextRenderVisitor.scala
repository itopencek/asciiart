package asciiArtApp

import asciiArtApp.models.images.grid.{AsciiImage, RgbImage}
import asciiArtApp.models.images.visitor.ImageVisitor

class ImageTextRenderVisitor extends ImageVisitor[String] {
  override def visitAsciiImage(image: AsciiImage): String = {
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

  override def visitRgbImage(image: RgbImage): String = ???
}
