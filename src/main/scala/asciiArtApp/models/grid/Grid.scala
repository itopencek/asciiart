package asciiArtApp.models.grid

import asciiArtApp.models.Entity

trait Grid[T] extends Entity {
  def foreach(func: T => Unit): Unit
}
