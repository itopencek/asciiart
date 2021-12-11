package asciiArtApp.models.grid

import asciiArtApp.models.Entity

trait Grid[T] extends Entity {
  def get(x: Int, y: Int): T
}
