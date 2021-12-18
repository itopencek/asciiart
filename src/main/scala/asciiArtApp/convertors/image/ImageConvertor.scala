package asciiArtApp.convertors.image

import asciiArtApp.convertors.Convertor
import asciiArtApp.models.image.grid.{GreyscaleImage, RgbImage}

trait ImageConvertor extends Convertor[RgbImage, GreyscaleImage] {

}
