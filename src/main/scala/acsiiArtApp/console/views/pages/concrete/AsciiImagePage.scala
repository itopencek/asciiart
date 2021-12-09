package acsiiArtApp.console.views.pages.concrete

import acsiiArtApp.console.views.pages.TextPage
import acsiiArtApp.console.views.rendering.ImageTextRenderVisitor
import acsiiArtApp.models.images.grid.AsciiImage

class AsciiImagePage(image: AsciiImage) extends TextPage {
  override def render(): String = {
    val imageVisitor = new ImageTextRenderVisitor

    image.accept(imageVisitor)
  }
}
