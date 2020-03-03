package org.ua.ilm.datastore.io.reader

import java.io.File

import scala.io.Source

class FileReader(file: File) {
  protected val source = Source.fromFile(file)

  def readFile(): String = {
    try source.getLines.toList.mkString
    finally source.close()
  }

  def readFileWithSeparator(): String = {
    try source.getLines.toList.mkString(",")
    finally source.close()
  }
}
