package models

trait Entity[T]
{
  /**
   * Returns id of this entity
   * @return
   */
  def id: T
}
