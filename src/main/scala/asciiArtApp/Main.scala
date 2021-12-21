package asciiArtApp

import asciiArtApp.console.ConsoleParser
import asciiArtApp.console.outputs.image.ImageOutput
import asciiArtApp.console.outputs.image.mixed.MixedOutput
import asciiArtApp.convertors.image.character.ToAsciiImageConvertor
import asciiArtApp.convertors.image.rgb.ToGreyscaleImageConvertor
import asciiArtApp.filters.image.ImageFilter
import asciiArtApp.filters.image.mixed.MixedFilter
import asciiArtApp.models.image.grid.{CharImage, GreyscaleImage, RgbImage}

object Main extends App {
  private def convert(image: RgbImage): GreyscaleImage = new ToGreyscaleImageConvertor().convert(image)
  private def convertAscii(image: GreyscaleImage): CharImage = new ToAsciiImageConvertor().convert(image)
  private def filter(filters: Seq[ImageFilter]) = new MixedFilter(filters)
  private def output(outputs: Seq[ImageOutput]) = new MixedOutput(outputs)
  val parser = new ConsoleParser

  try {
    // parse input arguments
    parser.parse(args.toList)

    // load image
    val rgbImage: RgbImage = parser.getLoader.load()
    // convert image
    val greyscaleImage = convert(rgbImage)
    // filter image
    val filteredImage = filter(parser.getFilters).filter(greyscaleImage)
    // convert to ascii
    val asciiImage = convertAscii(filteredImage)
    // export image
    output(parser.getOutputs).output(asciiImage)

  } catch {
    case e: Exception => println(e)
  }

}
