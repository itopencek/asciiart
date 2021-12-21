package asciiArtApp.loaders.file

import asciiArtApp.loaders.image.file.specific.{BitmapLoader, JpgLoader, PngLoader}
import asciiArtApp.models.grid.pixel.RgbGrid
import asciiArtApp.models.image.grid.RgbImage
import asciiArtApp.models.pixel.rgb.RGBPixel
import org.scalatest.FunSuite

import java.io.File

class FileRgbImageLoaderTests extends FunSuite {
  val colors: String = new File("src/test/resources/colors.bmp").getAbsolutePath
  val biOopPath: String = new File("src/test/resources/bi-oop.jpg").getAbsolutePath
  val imageCowboyPath: String = new File("src/test/resources/image-cowboy.png").getAbsolutePath
  val singlePixel: String = new File("src/test/resources/one-pixel.png").getAbsolutePath
  val imageCowboyString = "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 7951688 0 0 7951688 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 10395294 10395294 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2201331 0 0 2201331 0 0 0 0 0 0 0 0 0 0 0 0 0 0 7951688 2201331 0 0 0 0 2201331 7951688 0 0 0 0 0 0 0 0 0 0 0 0 7951688 2201331 0 0 0 0 2201331 7951688 0 0 0 0 0 0 0 0 0 0 0 0 0 2201331 0 0 0 0 2201331 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2201331 0 0 0 0 2201331 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2201331 0 0 0 0 2201331 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2201331 0 0 0 0 2201331 0 0 0 0 0 0 0 0 0 0 0 0 0 7951688 7951688 7951688 0 0 7951688 7951688 7951688 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0"
  // all image loaders
  def loadJPG(source: String): RgbImage = new JpgLoader(source).load()
  def loadPNG(source: String): RgbImage = new PngLoader(source).load()
  def loadBMP(source: String): RgbImage = new BitmapLoader(source).load()

  test("Basic import test - png - square") {
    val image: RgbImage = loadPNG(imageCowboyPath)
    var data = ""

    image.foreach(pixel => data += pixel.getRGB() + " ")
    // remove last space
    data = data.dropRight(1)

    assert(data == imageCowboyString)
  }

  test("Basic import test - jpg - rectangle") {
    val image: RgbImage = loadJPG(biOopPath)

    image.foreach(pixel => assert(pixel != null))
  }

  test("Basic import test - bitmap - rectangle") {
    val image: RgbImage = loadBMP(colors)
    val data = List[RGBPixel](RGBPixel(255, 0, 0), RGBPixel(9,5,247), RGBPixel(255,255,0), RGBPixel(255,132,0),
      RGBPixel(255,255,255), RGBPixel(0,0,0))
    val testImage = RgbImage(2, 3, RgbGrid(2, data))

    assert(image == testImage)
  }

  test("Import smallest 1x1 image") {
    val image = loadPNG(singlePixel)

    assert(image.getPixel(0, 0) == RGBPixel(0, 0, 0))
  }
}
