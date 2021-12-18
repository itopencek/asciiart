package exporters.text.concrete

/**
 * Exports to StdOut. Extends {@link StreamTextExporter}.
 */
class StdOutputExporter extends StreamTextExporter(System.out)
{

}
