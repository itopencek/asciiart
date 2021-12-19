package asciiArtApp.convertors.image

import asciiArtApp.loaders.image.file.specific.BitmapLoader
import asciiArtApp.models.grid.pixel.{GreyscaleGrid, RgbGrid}
import asciiArtApp.models.image.grid.{GreyscaleImage, RgbImage}
import asciiArtApp.models.pixel.char.GreyscalePixel
import asciiArtApp.models.pixel.rgb.RGBPixel
import org.scalatest.FunSuite

import java.io.File

class ToAsciiImageConvertorTest extends FunSuite {
  def imageConvertor(item: RgbImage): GreyscaleImage = new ToAsciiImageConvertor().convert(item)
  def loadBMP(source: String): RgbImage = new BitmapLoader(source).load()

  // images for testing
  val baseUrl = "src/test/resources"
  val imageColors: RgbImage = loadBMP(new File(baseUrl + "/colors.bmp").getAbsolutePath)

  test("Test basic conversion") {
    val result = imageConvertor(imageColors)
    val asciiImage = GreyscaleImage(2, 3, GreyscaleGrid(2, Array(GreyscalePixel("Z".head, 76),
      GreyscalePixel("#".head, 32), GreyscalePixel(";".head, 226), GreyscalePixel("|".head, 154),
      GreyscalePixel(" ".head, 255), GreyscalePixel("$".head, 0))))

    assert(result == asciiImage)
  }

  test("Test black image") {
    val array = Array[RGBPixel](RGBPixel(0, 0, 0), RGBPixel(0, 0, 0), RGBPixel(0, 0, 0), RGBPixel(0, 0, 0),
      RGBPixel(0, 0, 0), RGBPixel(0, 0, 0))
    val image = RgbImage(3, 2, RgbGrid(2, array))

    val converted = imageConvertor(image)

    val expectedArray = Array[GreyscalePixel](GreyscalePixel("$".head, 0), GreyscalePixel("$".head, 0),
      GreyscalePixel("$".head, 0), GreyscalePixel("$".head, 0), GreyscalePixel("$".head, 0),
      GreyscalePixel("$".head, 0))

    assert(converted == GreyscaleImage(3, 2, GreyscaleGrid(3, expectedArray)))
  }

  test("Test white image") {
    val array = Array[RGBPixel](RGBPixel(255, 255, 255), RGBPixel(255, 255, 255), RGBPixel(255, 255, 255),
      RGBPixel(255, 255, 255), RGBPixel(255, 255, 255), RGBPixel(255, 255, 255))
    val image = RgbImage(3, 2, RgbGrid(3, array))

    val converted = imageConvertor(image)

    val expectedArray = Array[GreyscalePixel](GreyscalePixel(" ".head, 255), GreyscalePixel(" ".head, 255),
      GreyscalePixel(" ".head, 255), GreyscalePixel(" ".head, 255), GreyscalePixel(" ".head, 255),
      GreyscalePixel(" ".head, 255))

    assert(converted == GreyscaleImage(3, 2, GreyscaleGrid(3, expectedArray)))
  }

  test("Test empty image") {
    val image = RgbImage(0, 0, RgbGrid(0, List[RGBPixel]()))
    val convertedImage = GreyscaleImage(0, 0, GreyscaleGrid(0, List[GreyscalePixel]()))

    val converted = imageConvertor(image)

    assert(converted == convertedImage)
  }
}
