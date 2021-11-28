package models.pixel

import models.Entity

trait Pixel extends Entity {
  // Int representation of pixel
  def getInt(): Int
}
