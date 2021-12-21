package asciiArtApp.models.grid.pixel

import asciiArtApp.models.pixel.rgb.RGBPixel
import org.scalatest.FunSuite

class RgbGridTest extends FunSuite {
  test("Test get") {
    val grid = RgbGrid(2, Array(RGBPixel(10, 10, 10), RGBPixel(101, 102, 103)))

    assert(grid.get(1, 0).r == 101)
    assert(grid.get(1, 0).g == 102)
    assert(grid.get(1, 0).b == 103)
  }

  test("Test index out of bounds exception") {
    val grid = RgbGrid(2, Array(RGBPixel(10, 10, 10), RGBPixel(101, 102, 103)))

    assertThrows[IndexOutOfBoundsException](grid.get(0, 1))
  }

  test("Test negative value exception") {
    val grid = RgbGrid(2, Array(RGBPixel(10, 10, 10), RGBPixel(101, 102, 103)))

    assertThrows[IndexOutOfBoundsException](grid.get(-1, 0))
  }

  test("Test index out of bounds exception 2") {
    val grid = RgbGrid(2, Array(RGBPixel(10, 10, 10), RGBPixel(101, 102, 103)))

    assertThrows[IndexOutOfBoundsException](grid.get(2, 0))
  }
}
