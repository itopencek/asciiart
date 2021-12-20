package asciiArtApp.console

import org.scalatest.FunSuite

class ConsoleParserTest extends FunSuite {
  val brightness: String = "--brightness"
  val flip: String = "--flip"
  val invert: String = "--invert"
  val random: String = "--image-random"
  val input: String = "--image"
  val outFile: String = "--output-file"
  val outConsole: String = "--output-console"

  test("Test with normal args") {

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
    val args = List[String](input, "100.jpg", random, outConsole)

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
