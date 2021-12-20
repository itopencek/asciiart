package asciiArtApp

import asciiArtApp.models.image.grid.GreyscaleImage
import asciiArtApp.models.image.visitor.ImageVisitor

/**
 * Visitor for {@link asciiArtApp.models.image.grid.PixelGridImage}. Implementation of {@link ImageVisitor}.
 */
class ImageTextRenderVisitor extends ImageVisitor[String] {
  /**
   * Returns {@link GreyscaleImage} in formatted {@link String}.
   *
   * @param image {@link GreyscaleImage} to visit
   * @return {@link String} of {@link GreyscaleImage}
   */
  override def visitGreyscaleImage(image: GreyscaleImage): String = {
    var response = ""
    var num = 0

    image.foreach(pixel =>
    {
      response += pixel.getChar()
      num += 1

      if (num % image.getWidth() == 0) {
        response += "\n"
      }
    })

    response
  }
}
