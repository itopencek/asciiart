package asciiArtApp.models.grid.pixel

import asciiArtApp.models.pixel.char.CharPixel
import org.scalatest.FunSuite

class CharGridTest extends FunSuite {

  test("Test get") {
    val grid = CharGrid(2, Array(CharPixel('a'), CharPixel('b')))

    assert(grid.get(0, 0).character == 'a')
  }

  test("Test index out of bounds exception") {
    val grid = CharGrid(2, Array(CharPixel('a'), CharPixel('b')))

    assertThrows[IndexOutOfBoundsException](grid.get(0, 1))
  }

  test("Test negative value exception") {
    val grid = CharGrid(2, Array(CharPixel('a'), CharPixel('b')))

    assertThrows[IndexOutOfBoundsException](grid.get(-1, 0))
  }

  test("Test index out of bounds exception 2") {
    val grid = CharGrid(2, Array(CharPixel('a'), CharPixel('b')))

    assertThrows[IndexOutOfBoundsException](grid.get(2, 0))
  }

}
