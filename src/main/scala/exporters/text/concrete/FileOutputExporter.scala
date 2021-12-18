package exporters.text.concrete

import java.io.{File, FileOutputStream}

/**
 * Exports to {@link File}. Extends {@link StreamTextExporter}.
 *
 * @param file {@link File} to export to
 */
class FileOutputExporter(file: File)
  extends StreamTextExporter(new FileOutputStream(file))
{

}

