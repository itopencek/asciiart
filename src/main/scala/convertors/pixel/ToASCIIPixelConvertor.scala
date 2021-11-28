package convertors.pixel
import models.pixel.ascii.ASCIIPixel
import models.pixel.rgb.RGBPixel

class ToASCIIPixelConvertor extends PixelConvertor {
  private val asciiChars = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/|()1{}[]?-_+~<>i!lI;:,\"^`\'. "

  override def convert(item: RGBPixel): ASCIIPixel = {
    val greyScale = (0.3 * item.r) + (0.59 * item.g) + (0.11 * item.b)
    val rampLength = asciiChars.length
    val index = ((rampLength - 1) * greyScale / 255).toInt

    ASCIIPixel(asciiChars.charAt(index))
  }
}
