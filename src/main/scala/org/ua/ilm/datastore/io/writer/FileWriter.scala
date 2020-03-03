package org.ua.ilm.datastore.io.writer

import java.io.{BufferedWriter, File}

class FileWriter(val file: File) {

  def writeFile(s: String): Unit = {
    val bw = new BufferedWriter(new java.io.FileWriter(file))
    try bw.write(s)
    finally bw.close()
  }
}
