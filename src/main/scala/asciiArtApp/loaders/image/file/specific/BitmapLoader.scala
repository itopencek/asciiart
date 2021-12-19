package asciiArtApp.loaders.image.file.specific

import asciiArtApp.loaders.image.file.FileRgbImageLoader
import asciiArtApp.models.image.grid.RgbImage

class BitmapLoader(source: String) extends FileRgbImageLoader {
  private val EXTENSION = "bmp"

  override def load(): RgbImage = {
    if (source.takeRight(3) != EXTENSION) {
      throw new IllegalArgumentException("Wrong extension type for BitmapLoader.")
    }

    handleImage(readImage(source))
  }
}
