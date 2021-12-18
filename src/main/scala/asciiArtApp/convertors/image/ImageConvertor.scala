package asciiArtApp.convertors.image

import asciiArtApp.convertors.Convertor
import asciiArtApp.models.image.grid.{GreyscaleImage, RgbImage}

/**
 * {@link Convertor}, which converts {@link RgbImage} to {@link GreyscaleImage}.
 */
trait ImageConvertor extends Convertor[RgbImage, GreyscaleImage] {

}
