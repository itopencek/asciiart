package asciiArtApp.models.grid.pixel

import asciiArtApp.models.pixel.char.GreyscalePixel
import org.scalatest.FunSuite

class GreyscaleGridTest extends FunSuite {
  test("Test get") {
    val grid = GreyscaleGrid(2, Array(GreyscalePixel(10), GreyscalePixel(100)))

    assert(grid.get(0, 0).brightness == 10)
  }

  test("Test index out of bounds exception") {
    val grid = GreyscaleGrid(2, Array(GreyscalePixel(10), GreyscalePixel(100)))

    assertThrows[IndexOutOfBoundsException](grid.get(0, 1))
  }

  test("Test negative value exception") {
    val grid = GreyscaleGrid(2, Array(GreyscalePixel(10), GreyscalePixel(100)))

    assertThrows[IndexOutOfBoundsException](grid.get(-1, 0))
  }

  test("Test index out of bounds exception 2") {
    val grid = GreyscaleGrid(2, Array(GreyscalePixel(10), GreyscalePixel(100)))

    assertThrows[IndexOutOfBoundsException](grid.get(2, 0))
  }
}
