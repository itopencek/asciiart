package models.images

import models.Entity

trait Image extends Entity[Int] {
  /**
   * Returns a new Image with a new id.
   *
   * @param newId new id
   * @return Image
   */
  def withId(newId: Int): Image
}
