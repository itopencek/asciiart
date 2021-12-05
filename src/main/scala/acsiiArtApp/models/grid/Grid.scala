package acsiiArtApp.models.grid

import acsiiArtApp.models.Entity

trait Grid[T] extends Entity {
  def foreach(func: T => Unit): Unit
}
