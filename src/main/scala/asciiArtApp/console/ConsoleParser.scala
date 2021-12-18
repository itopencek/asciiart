package asciiArtApp.console

import asciiArtApp.console.outputs.image.ImageOutput
import asciiArtApp.console.outputs.image.specific.{ConsoleOutput, FileOutput}
import asciiArtApp.filters.grid.ImageFilter
import asciiArtApp.filters.grid.defaults.GridIdentityFilter
import asciiArtApp.filters.grid.specific.{BrightnessFilter, FlipFilter, InvertFilter}
import asciiArtApp.loaders.image.RgbImageLoader
import asciiArtApp.loaders.image.file.FileRgbImageLoader
import asciiArtApp.loaders.image.random.RandomRgbImageLoader
import asciiArtApp.models.`enum`.FlipEnum

import java.io.File

/**
 * {@link Parser} for String parameters in console.
 */
class ConsoleParser extends Parser[String] {
  private val filters = List[ImageFilter](new GridIdentityFilter())
  private val outputs = List[ImageOutput]()
  private var alreadySetInput = false
  private var loader: RgbImageLoader = new RandomRgbImageLoader

  /**
   * Parses all available console arguments.
   *
   * @param arguments arguments to parse
   * @throws IllegalArgumentException if argument is unknown or more input parameters were specified
   */
  override def parse(arguments: Seq[String]): Unit = {
    arguments match {
      case "--brightness" :: value :: tail =>
        filters :+ new BrightnessFilter(value.toInt)
        parse(tail)
      case "--flip" :: axis :: tail =>
        filters :+ new FlipFilter(FlipEnum.withName(axis))
        parse(tail)
      case "--invert" :: tail => parse(tail)
        filters :+ new InvertFilter()
        parse(tail)
      case "--image-random" :: tail =>
        checkInputArg()
        parse(tail)
      case "--image" :: path :: tail =>
        checkInputArg()
        loader = new FileRgbImageLoader(path)
        parse(tail)
      case "--output-file" :: path :: tail =>
        outputs :+ new FileOutput(new File(path))
        parse(tail)
      case "--output-console" :: tail =>
        outputs :+ new ConsoleOutput()
        parse(tail)
      case unknownArgument => throw new IllegalArgumentException("Unknown argument(s) used. " + unknownArgument)
    }
  }

  /**
   * Checks if input argument was already parsed, if yes then throws IllegalArgumentException.
   */
  private def checkInputArg(): Unit = {
    if (alreadySetInput) {
      throw new IllegalArgumentException("Only one input argument allowed.")
    }
    alreadySetInput = true
  }

  def getFilters: Seq[ImageFilter] = filters

  def getOutputs: Seq[ImageOutput] = outputs

  /**
   * Returns {@link RgbImageLoader} if it was set, otherwise throws IllegalArgumentException.
   */
  def getLoader: RgbImageLoader = {
    if (!alreadySetInput) {
      throw new IllegalArgumentException("At least one input argument expected.")
    }

    loader
  }
}
