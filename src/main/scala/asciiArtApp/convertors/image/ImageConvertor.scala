package asciiArtApp.convertors.image

import asciiArtApp.convertors.Convertor
import asciiArtApp.models.images.grid.{GreyscaleImage, RgbImage}

trait ImageConvertor extends Convertor[RgbImage, GreyscaleImage] {

}
