package asciiArtApp.console.views.pages.concrete

import asciiArtApp.console.views.pages.TextPage
import asciiArtApp.console.views.rendering.ImageTextRenderVisitor
import asciiArtApp.models.images.grid.AsciiImage

class AsciiImagePage(image: AsciiImage) extends TextPage {
  override def render(): String = {
    val imageVisitor = new ImageTextRenderVisitor

    image.accept(imageVisitor)
  }
}
