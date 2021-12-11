package loaders

import asciiArtApp.models.grid.pixel.RgbGrid
import asciiArtApp.models.images.grid.RgbImage
import asciiArtApp.models.pixel.rgb.RGBPixel
import loaders.image.file.FileRgbImageLoader
import org.scalatest.FunSuite

import java.io.File

class FileRgbImageLoaderTests extends FunSuite {
  val colors: String = new File("src/test/resources/colors.bmp").getAbsolutePath
  val biOopPath: String = new File("src/test/resources/bi-oop.jpg").getAbsolutePath
  val imageCowboyPath: String = new File("src/test/resources/image-cowboy.png").getAbsolutePath
  val imageCowboyString = "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 7951688 0 0 7951688 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 10395294 10395294 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2201331 0 0 2201331 0 0 0 0 0 0 0 0 0 0 0 0 0 0 7951688 2201331 0 0 0 0 2201331 7951688 0 0 0 0 0 0 0 0 0 0 0 0 7951688 2201331 0 0 0 0 2201331 7951688 0 0 0 0 0 0 0 0 0 0 0 0 0 2201331 0 0 0 0 2201331 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2201331 0 0 0 0 2201331 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2201331 0 0 0 0 2201331 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2201331 0 0 0 0 2201331 0 0 0 0 0 0 0 0 0 0 0 0 0 7951688 7951688 7951688 0 0 7951688 7951688 7951688 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0"
  def load(source: String): RgbImage = new FileRgbImageLoader().load(source)

  test("Basic import test - png - square") {
    val image: RgbImage = load(imageCowboyPath)
    var data = ""

    image.foreach(pixel => data += pixel.getInt() + " ")
    // remove last space
    data = data.dropRight(1)

    assert(data == imageCowboyString)
  }

  test("Basic import test - jpg - rectangle") {
    val image: RgbImage = load(biOopPath)

    image.foreach(pixel => assert(pixel != null))
  }

  test("Basic import test - bitmap - rectangle") {
    val image: RgbImage = load(colors)
    val data = List[RGBPixel](RGBPixel(255, 0, 0), RGBPixel(9,5,247), RGBPixel(255,255,0), RGBPixel(255,132,0),
      RGBPixel(255,255,255), RGBPixel(0,0,0))
    val testImage = RgbImage(2, 3, RgbGrid(2, data))

    assert(image == testImage)
  }

  test("Import non existing file") {

  }

  test("Import 0x0 image") {

  }

  test("Import black and white picture") {

  }
}
