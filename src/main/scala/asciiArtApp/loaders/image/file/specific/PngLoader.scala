package asciiArtApp.loaders.image.file.specific

import asciiArtApp.loaders.image.file.FileRgbImageLoader
import asciiArtApp.models.image.grid.RgbImage

class PngLoader(source: String) extends FileRgbImageLoader {
  private val EXTENSION = "png"

  override def load(): RgbImage = {
    if (source.takeRight(3) != EXTENSION) {
      throw new IllegalArgumentException("Wrong extension type for PngLoader.")
    }

    handleImage(readImage(source))
  }
}
