package asciiArtApp.convertors.image.character

import asciiArtApp.convertors.Convertor
import asciiArtApp.models.image.grid.{CharImage, GreyscaleImage}

/**
 * {@link Convertor}, which converts {@link GreyscaleImage} to {@link CharImage}.
 */
trait CharImageConvertor extends Convertor[GreyscaleImage, CharImage] {

}
