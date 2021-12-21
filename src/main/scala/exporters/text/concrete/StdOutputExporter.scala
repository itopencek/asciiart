package exporters.text.concrete

/**
 * Exports to StdOut. Extends {@link StreamTextExporter}.
 */
class StdOutputExporter extends StreamTextExporter(System.out)
{
  /**
   * Overridden close method from {@link StreamTextExporter} to do nothing.
   */
  override def close(): Unit = {

  }
}
