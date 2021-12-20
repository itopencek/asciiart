package asciiArtApp.console

import asciiArtApp.console.outputs.image.ImageOutput
import asciiArtApp.console.outputs.image.specific.{ConsoleOutput, FileOutput}
import asciiArtApp.filters.image.ImageFilter
import asciiArtApp.filters.image.defaults.ImageIdentityFilter
import asciiArtApp.filters.image.specific.{BrightnessFilter, FlipFilter, InvertFilter}
import asciiArtApp.loaders.image.RgbImageLoader
import asciiArtApp.loaders.image.file.specific.{BitmapLoader, JpgLoader, PngLoader}
import asciiArtApp.loaders.image.random.RandomRgbImageLoader
import asciiArtApp.models.`enum`.FlipEnum

import java.io.File

/**
 * {@link Parser} used for String parameters in console.
 */
class ConsoleParser extends Parser[String] {
  private val filters = List[ImageFilter](new ImageIdentityFilter())
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
        setImageLoader(path)
        parse(tail)
      case "--output-file" :: path :: tail =>
        outputs :+ new FileOutput(new File(path))
        parse(tail)
      case "--output-console" :: tail =>
        outputs :+ new ConsoleOutput()
        parse(tail)
      case Nil =>
      case unknownArgument =>
        print(arguments)
        throw new IllegalArgumentException("Unknown argument(s) used. " + unknownArgument)
    }
  }

  /**
   * Checks if input argument was already parsed, if yes then throws {@link IllegalArgumentException}.
   */
  private def checkInputArg(): Unit = {
    if (alreadySetInput) {
      throw new IllegalArgumentException("Only one input argument allowed.")
    }
    alreadySetInput = true
  }

  def getFilters: Seq[ImageFilter] = filters

  def getOutputs: Seq[ImageOutput] = {
    if (outputs.isEmpty) {
      throw new IllegalArgumentException("No output.")
    }
    outputs
  }

  /**
   * Returns {@link RgbImageLoader} if it was set, otherwise throws {@link IllegalArgumentException}.
   */
  def getLoader: RgbImageLoader = {
    if (!alreadySetInput) {
      throw new IllegalArgumentException("At least one input argument expected.")
    }

    loader
  }

  /**
   * Sets correct image loader based on extension. If extension is unknown throws {@link IllegalArgumentException}.
   */
  private def setImageLoader(source: String): Unit = {
    source.takeRight(3) match {
      case "jpg" => loader = new JpgLoader(source)
      case "png" => loader = new PngLoader(source)
      case "bmp" => loader = new BitmapLoader(source)
      case extension => throw new IllegalArgumentException("Unsupported file extension " + extension)
    }
  }
}
