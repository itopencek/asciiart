package asciiArtApp

import asciiArtApp.console.ConsoleParser
import asciiArtApp.console.outputs.image.ImageOutput
import asciiArtApp.console.outputs.image.mixed.MixedOutput
import asciiArtApp.convertors.image.ToAsciiImageConvertor
import asciiArtApp.filters.image.ImageFilter
import asciiArtApp.filters.image.mixed.MixedFilter
import asciiArtApp.models.image.grid.{GreyscaleImage, RgbImage}

object Main extends App {
  private def convert(image: RgbImage): GreyscaleImage = new ToAsciiImageConvertor().convert(image)
  private def filter(filters: Seq[ImageFilter]) = new MixedFilter(filters)
  private def output(outputs: Seq[ImageOutput]) = new MixedOutput(outputs)
  val parser = new ConsoleParser

  try {
    // parse input arguments
    parser.parse(args)

    // load image
    val rgbImage: RgbImage = parser.getLoader.load()
    // convert image
    val asciiImage = convert(rgbImage)
    // filter image
    val filteredImage = filter(parser.getFilters).filter(asciiImage)
    // export image
    output(parser.getOutputs).output(filteredImage)

  } catch {
    case e: Exception => println(e)
  }

}
