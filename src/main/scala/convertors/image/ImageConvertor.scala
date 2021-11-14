package convertors.image

import convertors.Convertor

import java.awt.image.BufferedImage

trait ImageConvertor[T] extends Convertor[BufferedImage, T] {

}
