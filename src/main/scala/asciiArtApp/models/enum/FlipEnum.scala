package asciiArtApp.models.`enum`

/**
 * Enum to show what side to flip {@link asciiArtApp.models.image.Image} in
 * {@link asciiArtApp.filters.image.specific.FlipFilter}.
 */
object FlipEnum extends Enumeration {
  type FlipEnum = Value

  /**
   * Values represent X, Y axis.
   */
  val X, Y = Value
}
