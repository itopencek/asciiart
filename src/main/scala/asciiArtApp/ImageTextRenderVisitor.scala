package asciiArtApp

import asciiArtApp.models.image.grid.{GreyscaleImage, RgbImage}
import asciiArtApp.models.image.visitor.ImageVisitor

class ImageTextRenderVisitor extends ImageVisitor[String] {
  override def visitAsciiImage(image: GreyscaleImage): String = {
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
