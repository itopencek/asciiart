package asciiArtApp.console.views.rendering

import asciiArtApp.models.images.grid.{CharImage, RgbImage}
import asciiArtApp.models.images.visitor.ImageVisitor

class ImageTextRenderVisitor extends ImageVisitor[String] {
  override def visitAsciiImage(image: CharImage): String = {
    var output = ""

    for (x <- 0 until image.getHeight()) {
      for (y <- 0 until image.getWidth()) {
        output += image.getPixel(y, x).getInt().toChar
      }
      output += "\n"
    }
    // removes last newline
    output.dropRight(1)
  }

  /**
   *
   * @param image - image to visit
   * @return String consisting of integeres of individual pixel color representation (values divided by space)
   */
  override def visitRgbImage(image: RgbImage): String = {
    var output = ""

    for (y <- 0 to image.getHeight()) {
      for (x <- 0 to image.getWidth()) {
        output += image.getPixel(x, y).getInt() + " "
      }
      output += "\n"
    }
    // removes last newline and space
    output.dropRight(2)
  }
}
