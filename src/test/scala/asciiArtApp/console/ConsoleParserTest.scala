package asciiArtApp.console

import asciiArtApp.console.outputs.image.specific.{ConsoleOutput, FileOutput}
import asciiArtApp.filters.image.defaults.ImageIdentityFilter
import asciiArtApp.filters.image.specific.{BrightnessFilter, FlipFilter, InvertFilter}
import asciiArtApp.loaders.image.RgbImageLoader
import asciiArtApp.loaders.image.random.RandomRgbImageLoader
import org.scalatest.FunSuite

class ConsoleParserTest extends FunSuite {
  val brightness: String = "--brightness"
  val flip: String = "--flip"
  val invert: String = "--invert"
  val random: String = "--image-random"
  val input: String = "--image"
  val outFile: String = "--output-file"
  val outConsole: String = "--output-console"

  test("Test with normal args random") {
    val file = "src/test/resources/exports/output.out"
    val args = List[String](random, invert, flip, "X", flip, "Y", brightness, "100", outFile,
      file, outConsole)

    val parser = new ConsoleParser()

    parser.parse(args)

    assert(parser.getLoader.isInstanceOf[RandomRgbImageLoader])
    assert(parser.getOutputs.head.isInstanceOf[FileOutput])
    assert(parser.getOutputs(1).isInstanceOf[ConsoleOutput])
    assert(parser.getFilters.head.isInstanceOf[ImageIdentityFilter])
    assert(parser.getFilters(1).isInstanceOf[InvertFilter])
    assert(parser.getFilters(2).isInstanceOf[FlipFilter])
    assert(parser.getFilters(3).isInstanceOf[FlipFilter])
    assert(parser.getFilters(4).isInstanceOf[BrightnessFilter])
  }

  test("Test with normal args file") {
    val inputFile = "src/resources/colors.bmp"
    val args = List[String](input, inputFile, invert, flip, "Y", brightness, "-100", outConsole)

    val parser = new ConsoleParser()

    parser.parse(args)

    assert(parser.getLoader.isInstanceOf[RgbImageLoader])
    assert(parser.getOutputs.head.isInstanceOf[ConsoleOutput])
    assert(parser.getFilters.head.isInstanceOf[ImageIdentityFilter])
    assert(parser.getFilters(1).isInstanceOf[InvertFilter])
    assert(parser.getFilters(2).isInstanceOf[FlipFilter])
    assert(parser.getFilters(3).isInstanceOf[BrightnessFilter])
  }

  test("Test wrong flip argument") {
    // needs to be capital X or Y
    val args = List[String](random, flip, "y")

    assertThrows[NoSuchElementException](new ConsoleParser().parse(args))
  }

  test("Test unknown argument") {
    val args = List[String](brightness, "100", "--not-in-args", "10")

    assertThrows[IllegalArgumentException](new ConsoleParser().parse(args))
  }

  test("Test without input") {
    val args = List[String](brightness, "100", outConsole)

    val parser = new ConsoleParser()
    parser.parse(args)

    assertThrows[IllegalArgumentException](parser.getLoader)
  }

  test("Test without image input file") {
    val args = List[String](input, brightness, "100", outConsole)

    val parser = new ConsoleParser()
    assertThrows[IllegalArgumentException](parser.parse(args))
  }

  test("Test with too many inputs") {
    val args = List[String](input, "100.png", random, outConsole)

    val parser = new ConsoleParser()

    assertThrows[IllegalArgumentException](parser.parse(args))
  }

  test("Test without output") {
    val args = List[String](input, "100.jpg")

    val parser = new ConsoleParser()

    parser.parse(args)
    assertThrows[IllegalArgumentException](parser.getOutputs)
  }

  test("Test unknown extension") {
    val args = List[String](input, "100.very-nice-text")

    val parser = new ConsoleParser()

    assertThrows[IllegalArgumentException](parser.parse(args))
  }
}
